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

import ssms.dal.daoImp.ScoreDaoImpl;
import ssms.entity.Score;

/**
 * 
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019年12月29日 下午9:09:29
 *
 */
public class MainScorePanel extends TableInfoPanel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private JTable table;
	
	private JLabel label_info;
	
	private JTextField txt_id;
	
	private JTextField txt_name;
	
	private JButton btn_search;	
	
	private JButton btn_addSco;

	private JButton btn_updateSco;

	private List<Score> scoList;

	private JScrollPane scrollPane;
	
	private ScoreDaoImpl scoreDaoImpl;
	
	private ScoreTableModel scoreTableModel = new ScoreTableModel();
	
	/**
	 * Launch the application.
	 */
	public MainScorePanel() {
		super();
		scoreDaoImpl = new ScoreDaoImpl();
		initPanel();
	}

	/**
	 * Create the frame.
	 */
	public void initPanel() {
		setLayout(null);
		label_info = new JLabel("学生成绩管理");
		label_info.setFont(new Font(label_info.getFont().getName(), label_info.getFont().getStyle(), 30));
		label_info.setBounds(350, 10, 200, 50);
		add(label_info);
		
		txt_id = new JTextField(15);
		txt_name = new JTextField(15);
		JLabel label_id = new JLabel("学号");
		JLabel label_name = new JLabel("姓名");
		btn_search = new JButton("搜索");
		
		label_id.setBounds(5,70, 40, 25);		
		txt_id.setBounds(50, 70, 100, 25);
		label_name.setBounds(180, 70, 40, 25);
		txt_name.setBounds(225, 70, 100, 25);
		btn_search.setBounds(330, 69, 80, 25);
		
		
		add(label_id);
		add(txt_id);
		add(label_name);
		add(txt_name);
		btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateTableBySearchValues();
			}
		});
		add(btn_search);
		
		btn_addSco = new JButton("填写");		
		btn_updateSco = new JButton("修改");
		btn_addSco.setBounds(750, 70, 80, 25);
		btn_updateSco.setBounds(850, 70, 80, 25);
		
		btn_addSco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InsertScoreInfoFrame(mainFrame());
				updateTable();
			}
		});
		btn_updateSco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UpdateScoreInfoFrame(mainFrame());
				updateTable();
			}
		});
		add(btn_addSco);
		add(btn_updateSco);
		
		initTable();
	}

	/**
	 * Initialize Table.
	 */
	public void initTable() {
		scoList = new ArrayList<Score>();
		scoList = scoreDaoImpl.getAllScore(); 		
		scoreTableModel.setScore(scoList); 
		
		table = new JTable();
		table.setRowHeight(25);		
		table.setModel(scoreTableModel); 
		
		scrollPane = new JScrollPane(table);
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
		scoList = new ArrayList<Score>();
		scoList = scoreDaoImpl.getAllScore();
		scoreTableModel.setScore(scoList);
		scoreTableModel.fireTableDataChanged();
		add(scrollPane);		
		validate();
		repaint();
	}
	
	
	/**
	 * Update Table By Search Values.
	 */
	public void updateTableBySearchValues() {
		scoList = new ArrayList<Score>();
		scoList = scoreDaoImpl.getAllScoreByIdAndName(txt_id.getText(), txt_name.getName());
		scoreTableModel.setScore(scoList);
		scoreTableModel.fireTableDataChanged();
		add(scrollPane);		
		validate();
		repaint();
	}
	
	/**
	 * Get Current Select Obj
	 */
	public Object getCurrentSelect() {
		if(table.getSelectedRow()<0) return null;		
		return scoList.get(table.getSelectedRow());	
	}
	
}
