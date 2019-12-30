package ssms.ui;

import javax.swing.JOptionPane;

import ssms.entity.Score;

/**
 * 
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019��12��29�� ����11:23:08
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
			JOptionPane.showMessageDialog(getParent(), "��ѧ���ɼ��Ѿ�¼��,�����޸������޸İ�ť�����޸�", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(getParent(), "��ѧ���ɼ��Ѿ�¼��,�����޸������޸İ�ť�����޸�", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);	
			operateButton().setEnabled(false);
			return;
		}
		btn_operate.setEnabled(true);
	}
	
}
