package ssms.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ssms.dal.daoImp.StudentDaoImpl;
import ssms.entity.Student;

/**
 * 
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019年12月29日 下午10:28:18
 *
 */
public class UpdateStudentInfoPanel extends StudentInfoPanel {

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Panel Title.
	 */
	public String panelTitle() {
		return "修改学生信息...";
	}
	
	/**
	 * Constructor.
	 */
	public UpdateStudentInfoPanel() {
		// TODO Auto-generated constructor stub
		super();				
	}
	
	/**
	 * fill fields.
	 */	
	public void fillFields() {
		Student student = (Student) getCurrentTablePanel().getCurrentSelect();
		if (null != student) {
			txt_studentId.setEditable(false);
			txt_studentId.setText(student.getId());
			txt_name.setText(student.getName());
			txt_age.setText(String.valueOf(student.getAge()));
			txt_className.setText(student.getClassName());
			if (student.getGender() == "女") {
				genderFemale.setSelected(true);
				genderMale.setSelected(false);
			}
		}	
	}

	/**
	 * Operate Button.
	 */
	public JButton operateButton() {
		JButton button = new JButton("修改学生信息");
		button.setBounds(160, 320, 150, 25);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = txt_studentId.getText();
				String name = txt_name.getText();
				String sAge = txt_age.getText();
				String gender = genderMale.isSelected() ? genderMale.getText() : genderFemale.getText();
				String className = txt_className.getText();
				if(id.isEmpty() || name.isEmpty() || sAge.isEmpty() || gender.isEmpty() || className.isEmpty()) {
					JOptionPane.showMessageDialog(getParent(), "请确保所有信息都不为空再确认修改", "修改学生信息提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (!isNumeric(sAge)) {
					JOptionPane.showMessageDialog(getParent(), "年龄必须是整数", "修改学生信息提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int age = Integer.parseInt(sAge);
				
				Student student = new Student(id, age, name, gender, className);
				
				StudentDaoImpl studentDaoImp = new StudentDaoImpl();
				if (studentDaoImp.updateStudent(student)) {
					JOptionPane.showMessageDialog(getParent(), "修改学生信息成功", "修改学生信息提示", JOptionPane.INFORMATION_MESSAGE);
					getParentFrame(getParent()).dispose();
					return;
				}
				JOptionPane.showMessageDialog(getParent(), "修改学生信息失败，数据库系统异常", "修改学生信息提示", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		});
		return button;
		
	}
	
	/**
	 * Get Parent Frame.
	 * @param component
	 * @return
	 */
	public StudentInfoFrame getParentFrame(Component component) {
		Component res = component.getParent();
		if(res == null) return null;
		if(res instanceof StudentInfoFrame) {
			return (StudentInfoFrame)res;
		}
		return getParentFrame(res);		
	}
	
}
