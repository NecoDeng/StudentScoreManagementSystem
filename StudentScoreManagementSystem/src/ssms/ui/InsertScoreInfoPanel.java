package ssms.ui;

import javax.swing.JOptionPane;

import ssms.entity.Score;

/**
 * 
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019年12月29日 下午11:23:08
 *
 */
public class InsertScoreInfoPanel extends ScoreInfoPanel{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public InsertScoreInfoPanel() {
		super();
	}

	/**
	 * FillFields.
	 */
	public void fillFields() {
		Score score = (Score) getCurrentTablePanel().getCurrentSelect();
		if (score == null) {
			getParentFrame(this).dispose();
			return;
		}
		
		txt_studentId.setText(score.getStudentId());
		txt_studentName.setText(score.getStudentName());					
		
		if(score.getChineseScore() >= 0 && score.getMathScore() >= 0 && score.getEnglishScore() >= 0) {
			JOptionPane.showMessageDialog(getParent(), "该学生成绩已经录入,如需修改请点击修改按钮进行修改", "信息提示", JOptionPane.INFORMATION_MESSAGE);
			txt_studentId.requestFocus();
			btn_operate.setEnabled(false);
			return;
		}
	}
	
	/**
	 * Handle Score.
	 */
	public void handleScore(Score score) {
		super.handleScore(score);
		if(score.getChineseScore() >= 0 && score.getMathScore() >= 0 && score.getEnglishScore() >= 0) {
			JOptionPane.showMessageDialog(getParent(), "该学生成绩已经录入,如需修改请点击修改按钮进行修改", "信息提示", JOptionPane.INFORMATION_MESSAGE);	
			operateButton().setEnabled(false);
			return;
		}
		btn_operate.setEnabled(true);
	}
	
}
