package ssms.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import ssms.entity.*;

public class ScoreTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//����һ��Student���б�
	List<Score> scoList = new ArrayList<Score>();

	//����Student�б�,ͬʱ֪ͨJTable���ݶ����Ѹ���,�ػ����
	public void setScore(final List<Score> list){
		//invokeLater()����:���� doRun.run() �� AWT �¼�ָ���߳����첽ִ�С������й���� AWT �¼��������ŷ�����
		//�˷���Ӧ����Ӧ�ó����߳���Ҫ���¸� GUI ʱʹ��
		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				scoList = list;
				fireTableDataChanged();  //֪ͨJTable���ݶ����Ѹ���,�ػ����
				System.out.println("���½���");
			}
			
		});
		
	}
	
	//����JTable������
	public int getColumnCount() {
		return 5;
	}

	//����JTable������
	public int getRowCount() {
		return scoList.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		String [] headers = {"ѧ��","����", "����","��ѧ", "Ӣ��"};
		if (0 <= column || column < 5) return headers[column];
		return super.getColumnName(column);
	}

	// ��List���ó�rowIndex��columnIndex����ʾ��ֵ     �������ø�TableModelָ����Ԫ���ֵ
	public Object getValueAt(int rowIndex, int columnIndex) {
		Score score = scoList.get(rowIndex); // ��ȡ��ǰ�е�Student
		switch (columnIndex) { // ������,����ֵ
		case 0:
			return score.getStudentId(); //��һ�� ѧ��
		case 1:
			return score.getStudentName();      //�ڶ��� ����
		case 2:
			return score.getChineseScore();       //������ �Ա�
		case 3:
			return score.getMathScore(); //������ �༶
		case 4:
			return score.getEnglishScore();   //������ ѧԺ
		default:
			break;
		}
		return null;
	}

}