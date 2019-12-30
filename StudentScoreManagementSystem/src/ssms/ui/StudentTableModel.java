package ssms.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import ssms.entity.*;

public class StudentTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//����һ��Student���б�
	List<Student> stuList = new ArrayList<Student>();

	//����Student�б�,ͬʱ֪ͨJTable���ݶ����Ѹ���,�ػ����
	public void setStudent(final List<Student> list){
		//invokeLater()����:���� doRun.run() �� AWT �¼�ָ���߳����첽ִ�С������й���� AWT �¼��������ŷ�����
		//�˷���Ӧ����Ӧ�ó����߳���Ҫ���¸� GUI ʱʹ��
		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				stuList = list;
				fireTableDataChanged();  //֪ͨJTable���ݶ����Ѹ���,�ػ����
			}
			
		});
		
	}
	
	//����JTable������
	public int getColumnCount() {
		return 5;
	}

	//����JTable������
	public int getRowCount() {
		return stuList.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		String [] headers = {"ѧ��","����", "����","�Ա�", "�༶"};
		if (0 <= column || column < 5) return headers[column];
		return super.getColumnName(column);
	}

	// ��List���ó�rowIndex��columnIndex����ʾ��ֵ     �������ø�TableModelָ����Ԫ���ֵ
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = stuList.get(rowIndex); // ��ȡ��ǰ�е�Student
		switch (columnIndex) { // ������,����ֵ
		case 0:
			return student.getId();   //��һ�� ѧ��
		case 1:
			return student.getName();      //�ڶ��� ����
		case 2:
			return student.getAge();       //������ �Ա�
		case 3:
			return student.getGender(); //������ �༶
		case 4:
			return student.getClassName();   //������ ѧԺ
		default:
			break;
		}
		return null;
	}

}