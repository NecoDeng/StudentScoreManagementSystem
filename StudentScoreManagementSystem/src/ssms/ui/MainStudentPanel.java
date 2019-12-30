package ssms.ui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ssms.dal.daoImp.StudentDaoImpl;
import ssms.entity.Student;

/**
 * 
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019��12��29�� ����9:09:46
 *
 */
public class MainStudentPanel extends TableInfoPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	
	private JLabel label_info;
	
	private JTextField txt_id;
	
	private JTextField txt_name;
	
	private JTextField txt_class;
	
	private JButton btn_search;	
	
	private JButton btn_addStu;

	private JButton btn_deleteStu;

	private JButton btn_updateStu;
	
	private List<Student> stuList;
	
	private JScrollPane scrollPane;	
	
	private StudentDaoImpl studentDaoImpl;

	private StudentTableModel studentTableModel = new StudentTableModel();

	/**
	 * Launch the application.
	 */
	public MainStudentPanel() {
		super();
		studentDaoImpl = new StudentDaoImpl();
		initPanel();
	}

	/**
	 * Create the frame.
	 */
	public void initPanel() {
		setLayout(null);
		
		label_info = new JLabel("ѧ����Ϣ����");
		label_info.setFont(new Font(label_info.getFont().getName(), label_info.getFont().getStyle(), 30));
		label_info.setBounds(350, 10, 200, 50);
		
		add(label_info);
		
		txt_id = new JTextField(15);
		txt_name = new JTextField(15);
		txt_class = new JTextField(15);
		
		JLabel label_id = new JLabel("ѧ��");
		JLabel label_name = new JLabel("����");
		JLabel label_class = new JLabel("�༶");
		btn_search = new JButton("����");
		
		label_id.setBounds(5,70, 40, 25);		
		txt_id.setBounds(50, 70, 100, 25);
		label_name.setBounds(180, 70, 40, 25);
		txt_name.setBounds(225, 70, 100, 25);
		label_class.setBounds(355, 70, 40, 25);
		txt_class.setBounds(400, 70, 100, 25);
		btn_search.setBounds(505, 69, 80, 25);		
		
		add(label_id);
		add(txt_id);
		add(label_name);
		add(txt_name);
		add(label_class);
		add(txt_class);
		btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateTableBySearchValues();
			}
		});
		add(btn_search);
		
		btn_addStu = new JButton("����");		
		btn_deleteStu = new JButton("ɾ��");		
		btn_updateStu = new JButton("�޸�");
		btn_addStu.setBounds(650, 69, 80, 25);
		btn_updateStu.setBounds(750, 69, 80, 25);
		btn_deleteStu.setBounds(850, 69, 80, 25);		
		
		btn_addStu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InsertStudentInfoFrame(mainFrame());
				updateTable();
			}
		});
		btn_updateStu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UpdateStudentInfoFrame(mainFrame());
				updateTable();
			}
		});
		btn_deleteStu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student student = (Student) getCurrentSelect();
				new StudentDaoImpl().delStudentbyID(student.getId());
				updateTable();
			}
		});
		add(btn_addStu);
		add(btn_updateStu);
		add(btn_deleteStu);		
		
		initTable();		
	}
	
	/**
	 * Initialize Table.
	 */
	public void initTable() {
		stuList = new ArrayList<Student>();
		stuList = studentDaoImpl.getAllStudent(); 
		studentTableModel.setStudent(stuList); 
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(studentTableModel);
		
		scrollPane = new JScrollPane(table); // ��ӱ����������
		scrollPane.setBounds(0, 100, 950, 700);		
		
		add(scrollPane);
	}

	/**
	 * Main Frame
	 * @return MainFrame.
	 */
	public MainFrame mainFrame() {
		return getMainFrame(getParent());	
	}
	
	/**
	 * Get Main Frame
	 * @param component
	 * @return MainFrame.
	 */
	public MainFrame getMainFrame(Component component) {
		Component res = component.getParent();
		if (res == null)
			return null;
		if (res instanceof MainFrame) {
			return (MainFrame) res;
		}
		return getMainFrame(res);
	}

	/**
	 * Update Table
	 */
	public void updateTable() {
		stuList = new ArrayList<Student>();
		stuList = studentDaoImpl.getAllStudent(); 
		studentTableModel.setStudent(stuList);
		studentTableModel.fireTableDataChanged();
		add(scrollPane);		
		validate();
		repaint();
	}
	
	/**
	 * Update Table By Search Values.
	 */
	public void updateTableBySearchValues() {
		stuList = new ArrayList<Student>();
		stuList = studentDaoImpl.getAllStudentByIdAndNameAndClass(txt_id.getText(), txt_name.getText(), txt_class.getText()); 
		studentTableModel.setStudent(stuList);
		studentTableModel.fireTableDataChanged();
		add(scrollPane);		
		validate();
		repaint();
	}
	
	/**
	 * Get Current Select Obj
	 */
	public Object getCurrentSelect() {
		if(table.getSelectedRow()<0) return null;		
		return stuList.get(table.getSelectedRow());			
	}
}
