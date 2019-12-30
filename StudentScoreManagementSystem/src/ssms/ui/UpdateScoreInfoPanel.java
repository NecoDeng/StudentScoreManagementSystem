package ssms.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ssms.dal.daoImp.ScoreDaoImpl;
import ssms.entity.Score;

public class UpdateScoreInfoPanel extends ScoreInfoPanel{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor.
	 */
	public UpdateScoreInfoPanel() {
		super();		
	}
	
	/**
	 * Fill Fields.
	 */
	public void fillFields() {
		Score score = (Score) getCurrentTablePanel().getCurrentSelect();
		if (score == null) { 
			JOptionPane.showMessageDialog(getParent(), "δѡ���κμ�¼", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
			getParentFrame(this).dispose();
			return;			
		}
		txt_studentId.setEditable(false);
		txt_studentId.setText(score.getStudentId());
		txt_studentName.setText(score.getStudentName());
		txt_chineseScore.setText(String.valueOf(score.getChineseScore()));
		txt_mathScore.setText(String.valueOf(score.getChineseScore()));
		txt_englishScore.setText(String.valueOf(score.getChineseScore()));
	}
	
	/**
	 * Panel Title.
	 */
	public String panelTitle() {
		return "���³ɼ���Ϣ... ";
	}
	
	/**
	 * Operate Button.
	 */
	public JButton operateButton() {
		JButton button = new JButton("���³ɼ���Ϣ");
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
					JOptionPane.showMessageDialog(getParent(), "��ȷ��������Ϣ����Ϊ����ȷ�ϸ���", "���³ɼ���Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (!isNumeric(sChinese) || !isNumeric(sMath) || !isNumeric(sEnglish)) {
					JOptionPane.showMessageDialog(getParent(), "�ɼ�����������", "���³ɼ���Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int chineseScore = Integer.parseInt(sChinese);
				int mathScore = Integer.parseInt(sMath);
				int englishScore = Integer.parseInt(sEnglish);
				
				Score score = new Score(studentId, chineseScore, mathScore, englishScore);
				
				ScoreDaoImpl scoreDaoImpl = new ScoreDaoImpl();
				boolean updated = false;
				
				Score tempScore = scoreDaoImpl.getScoreByStudentId(studentId);
				
				if(tempScore.getChineseScore() < 0 && tempScore.getMathScore() < 0 && tempScore.getEnglishScore() < 0) { if(scoreDaoImpl.addScore(score)) updated = true; }					
				if(!updated) if(scoreDaoImpl.updateScore(score)) { updated = true; }
				if(updated) {
					JOptionPane.showMessageDialog(getParent(), "�ɼ����³ɹ�������", "���³ɼ���Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(getParent(), "���³ɼ���Ϣʧ�ܣ����ݿ�ϵͳ�쳣", "���³ɼ���Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		});
		return button;
		
	}
	
}
