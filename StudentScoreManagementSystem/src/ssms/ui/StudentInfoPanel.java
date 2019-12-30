package ssms.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import ssms.dal.daoImp.StudentDaoImpl;
import ssms.entity.Student;

/**
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019��12��26�� ����10:55:44
 * 
 */
public class StudentInfoPanel extends JPanel{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField txt_studentId;
	JTextField txt_name;
	ButtonGroup btnGroup_gender;
	JRadioButtonMenuItem genderMale;
	JRadioButtonMenuItem genderFemale;
	JTextField txt_age = new JTextField(15);
	JTextField txt_className = new JTextField(15);

	JButton btn_operate;
	
	/**
	 * Constructor.
	 */
	public StudentInfoPanel() {
		// TODO Auto-generated constructor stub
		super();
		initPanel();
	}
	
	/**
	 * Panel Title.
	 * @return
	 */
	public String panelTitle() {
		return "���ѧ����Ϣ... ";
	}
	
	/**
	 * Initialize Panel.
	 */
	public void initPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(480, 500));
		setLayout(null);
		
		//title		
		JLabel label_title = new JLabel(panelTitle());
		label_title.setBounds(150, 15, 200, 50);
		add(label_title);
		
		
		//account field.
		JLabel label_studentId = new JLabel("ѧ��");		
		txt_studentId = new JTextField(15);
				
		JLabel label_name = new JLabel("����");
		txt_name = new JTextField(15);
		
		JLabel label_gender = new JLabel("�Ա�");
		btnGroup_gender = new ButtonGroup();
		genderMale = new JRadioButtonMenuItem("��", true);
		genderFemale = new JRadioButtonMenuItem("Ů", false);		
		
		JLabel label_age = new JLabel("����");
		txt_age = new JTextField(15);
		
		JLabel label_className = new JLabel("�༶");
		txt_className = new JTextField(15);
		
		btn_operate = operateButton();
		
		//set account and password bounds.
		txt_studentId.setBounds(150, 70, 180, 20);
		label_studentId.setBounds(70, 70, 80, 20);		
		
		label_name.setBounds(70, 120, 80, 20);
		txt_name.setBounds(150, 120, 180, 20);
		
		label_gender.setBounds(70, 170, 80, 20);		
		genderMale.setBounds(150, 170, 90, 20);
		genderFemale.setBounds(240, 170, 90, 20);
		genderMale.setBackground(Color.white);
		genderFemale.setBackground(Color.white);		
		btnGroup_gender.add(genderMale);
		btnGroup_gender.add(genderFemale);
		
		
		label_age.setBounds(70, 220, 80, 20);
		txt_age.setBounds(150, 220, 180, 20);
		
		label_className.setBounds(70, 270, 80, 20);
		txt_className.setBounds(150, 270, 180, 20);
		
		//add account and password into current panel.
		add(txt_studentId);
		add(label_studentId);
		add(txt_name);
		add(label_name);
		add(label_gender);
		add(genderMale);		
		add(genderFemale);
		add(label_age);
		add(txt_age);
		add(label_className);
		add(txt_className);
		add(btn_operate);
	}

	/**
	 * Operate Button
	 * @return
	 */
	public JButton operateButton() {
		JButton button = new JButton("���ѧ����Ϣ");
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
					JOptionPane.showMessageDialog(getParent(), "��ȷ��������Ϣ����Ϊ����ȷ�����", "���ѧ����Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (!isNumeric(sAge)) {
					JOptionPane.showMessageDialog(getParent(), "�������������", "���ѧ����Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int age = Integer.parseInt(sAge);
				
				Student student = new Student(id, age, name, gender, className);
				
				StudentDaoImpl studentDaoImp = new StudentDaoImpl();
				if (studentDaoImp.addStudent(student)) {
					JOptionPane.showMessageDialog(getParent(), "���ѧ����Ϣ�ɹ�", "���ѧ����Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);				
					getCurrentTablePanel().updateTable();
					return;
				}
				JOptionPane.showMessageDialog(getParent(), "���ѧ����Ϣʧ�ܣ����ݿ�ϵͳ�쳣", "���ѧ����Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		});
		return button;		
	}
	
	/**
	 * Is Number
	 * @param str
	 * @return boolean
	 */
	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
		
	/**
	 * Get Current Table Panel.
	 * @return TableInfoPanel
	 */
	public TableInfoPanel getCurrentTablePanel() {
		System.out.println(getParent());
		TableInfoPanel tablePanel = (TableInfoPanel) getMainFrame(getParent()).getTabbedPanel().getSelectedComponent();
		return tablePanel;
	}
	
	/**
	 * Get MainFrame.
	 * @param component
	 * @return MainFrame
	 */
	public MainFrame getMainFrame(Component component) {
		Component res = component.getParent();
		if(res == null) return null;
		if(res instanceof MainFrame) {
			return (MainFrame)res;
		}
		return getMainFrame(res);		
	}
	
}