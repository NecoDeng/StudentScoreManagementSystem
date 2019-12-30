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
	
	//保存一个Student的列表
	List<Score> scoList = new ArrayList<Score>();

	//设置Student列表,同时通知JTable数据对象已更改,重绘界面
	public void setScore(final List<Score> list){
		//invokeLater()方法:导致 doRun.run() 在 AWT 事件指派线程上异步执行。在所有挂起的 AWT 事件被处理后才发生。
		//此方法应该在应用程序线程需要更新该 GUI 时使用
		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				scoList = list;
				fireTableDataChanged();  //通知JTable数据对象已更改,重绘界面
				System.out.println("更新界面");
			}
			
		});
		
	}
	
	//返回JTable的列数
	public int getColumnCount() {
		return 5;
	}

	//返回JTable的行数
	public int getRowCount() {
		return scoList.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		String [] headers = {"学号","姓名", "语文","数学", "英语"};
		if (0 <= column || column < 5) return headers[column];
		return super.getColumnName(column);
	}

	// 从List中拿出rowIndex行columnIndex列显示的值     用于设置该TableModel指定单元格的值
	public Object getValueAt(int rowIndex, int columnIndex) {
		Score score = scoList.get(rowIndex); // 获取当前行的Student
		switch (columnIndex) { // 根据列,返回值
		case 0:
			return score.getStudentId(); //第一列 学号
		case 1:
			return score.getStudentName();      //第二列 姓名
		case 2:
			return score.getChineseScore();       //第三列 性别
		case 3:
			return score.getMathScore(); //第四列 班级
		case 4:
			return score.getEnglishScore();   //第五列 学院
		default:
			break;
		}
		return null;
	}

}