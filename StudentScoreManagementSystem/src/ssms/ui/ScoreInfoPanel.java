package ssms.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ssms.dal.daoImp.ScoreDaoImpl;
import ssms.entity.Score;

/**
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019年12月26日 下午10:55:44
 * 
 */
public class ScoreInfoPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField txt_studentId;
	JTextField txt_studentName;
	JTextField txt_chineseScore = new JTextField(15);
	JTextField txt_mathScore = new JTextField(15);
	JTextField txt_englishScore = new JTextField(15);

	JButton btn_operate;
	
	/**
	 * Constructor.
	 */
	public ScoreInfoPanel() {
		// TODO Auto-generated constructor stub
		super();
		initPanel();
	}
	
	public String panelTitle() {
		return "添加成绩信息... ";
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
		JLabel label_studentId = new JLabel("学号");		
		txt_studentId = new JTextField(15);
		txt_studentId.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				ScoreDaoImpl dao = new ScoreDaoImpl();
				Score score = dao.getScoreByStudentId(txt_studentId.getText());
				if(score != null) handleScore(score);				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
				
		JLabel label_studentName = new JLabel("姓名");
		txt_studentName = new JTextField(15);
		txt_studentName.setEditable(false);
		
		JLabel label_chinese = new JLabel("语文");
		txt_chineseScore = new JTextField();
		
		JLabel label_math = new JLabel("数学");
		txt_mathScore = new JTextField(15);		
		
		JLabel label_english= new JLabel("英语");
		txt_englishScore= new JTextField(15);
		
		btn_operate = operateButton();
		
		//set account and password bounds.
		label_studentId.setBounds(70, 70, 80, 20);		
		txt_studentId.setBounds(150, 70, 180, 20);
		
		label_studentName.setBounds(70, 120, 80, 20);
		txt_studentName.setBounds(150, 120, 180, 20);
		
		label_chinese.setBounds(70, 170, 80, 20);
		txt_chineseScore.setBounds(150, 170, 180, 20);
		
		label_math.setBounds(70, 220, 80, 20);
		txt_mathScore.setBounds(150, 220, 180, 20);
		
		label_english.setBounds(70, 270, 80, 20);
		txt_englishScore.setBounds(150, 270, 180, 20);
		
		//add account and password into current panel.
		add(label_studentId);
		add(label_studentName);
		add(label_chinese);
		add(label_math);
		add(label_english);
		add(txt_studentId);		
		add(txt_studentName);
		add(txt_chineseScore);
		add(txt_mathScore);
		add(txt_englishScore);
		add(btn_operate);
	}

	/**
	 * Fill Fields.
	 */
	public void fillFields(){
	
	}
	
	/**
	 * Operate Button.
	 * @return JButton.
	 */
	public JButton operateButton() {
		JButton button = new JButton("添加成绩信息");
		button.setBounds(160, 320, 150, 25);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String studentId = txt_studentId.getText();
				String sChinese = txt_chineseScore.getText();
				String sMath = txt_mathScore.getText();
				String sEnglish = txt_englishScore.getText();
				if(studentId.isEmpty() || sChinese.isEmpty() || sMath.isEmpty() || sEnglish.isEmpty()) {
					JOptionPane.showMessageDialog(getParent(), "请确保所有信息都不为空再确认添加", "添加成绩信息提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (!isNumeric(sChinese) || !isNumeric(sMath) || !isNumeric(sEnglish)) {
					JOptionPane.showMessageDialog(getParent(), "成绩必须是整数", "添加成绩信息提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int chineseScore = Integer.parseInt(sChinese);
				int mathScore = Integer.parseInt(sMath);
				int englishScore = Integer.parseInt(sEnglish);
				
				Score score = new Score(studentId, chineseScore, mathScore, englishScore);
				
				ScoreDaoImpl scoreDaoImpl = new ScoreDaoImpl();
				if(scoreDaoImpl.addScore(score)) {
					JOptionPane.showMessageDialog(getParent(), "成绩添加成功！！！", "添加成绩信息提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(getParent(), "添加成绩信息失败，数据库系统异常", "添加成绩信息提示", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		});
		return button;
		
	}
	
	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
		
	public ScoreInfoFrame getParentFrame(Component component) {
		Component res = component.getParent();
		if(res == null) return null;
		if(res instanceof ScoreInfoFrame) {
			return (ScoreInfoFrame)res;
		}
		return getParentFrame(res);		
	}

	
	public void handleScore(Score score) {
		txt_studentName.setText(score.getStudentName());		
	}
		
	/**
	 * Get Current Table Panel.
	 * @return TableInfoPanel
	 */
	public TableInfoPanel getCurrentTablePanel() {
		TableInfoPanel tablePanel = (TableInfoPanel) getMainFrame(getParent()).getTabbedPanel().getSelectedComponent();
		System.out.println(tablePanel);
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