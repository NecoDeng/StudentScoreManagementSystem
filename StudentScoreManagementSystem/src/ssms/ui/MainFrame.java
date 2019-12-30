package ssms.ui;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * 
 * @author VULCAN
 *	 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019年12月29日 下午11:40:18
 *
 */
public class MainFrame extends JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	public JTabbedPane tabbedPanel;

	public TableInfoPanel tableInfoPanel;

	/**
	 * Get Table Info Panel.
	 * 
	 * @return
	 */
	public TableInfoPanel getTableInfoPanel() {
		if (tableInfoPanel == null)
			tableInfoPanel = new MainScorePanel();
		return tableInfoPanel;
	}

	/**
	 * Get Tabbed Panel.
	 * 
	 * @return
	 */
	public JTabbedPane getTabbedPanel() {
		if (tabbedPanel == null) {
			tabbedPanel = new JTabbedPane();
			tabbedPanel.addTab("学生信息管理", new MainStudentPanel());
			tabbedPanel.addTab("学生成绩管理", new MainScorePanel());
		}
		return tabbedPanel;
	}

	/**
	 * Constructor.
	 */
	public MainFrame() {
		super();
		try {
			initFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize Frame.
	 * 
	 * @throws IOException
	 */
	public void initFrame() throws IOException {
		setResizable(false);
		setTitle("学生成绩管理系统");
		setBounds(originalPoint(), frameDimension());
		setIconImage(ImageIO.read(new File("src\\tetris.jpg")));
		getContentPane().setSize(frameDimension());
		getContentPane().setLayout(null);
		getTabbedPanel().setBounds(125, 0, 950, 800);
		getContentPane().add(tabbedPanel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * @return Current Frame Dimension.
	 */
	private Dimension frameDimension() {
		return new Dimension(1200, 800);
	}

	/**
	 * @return the original point.
	 */
	private Point2D originalPoint() {
		return new Point2D((TetrisDimension.SCREEN_DIMENSION.getWidth() - frameDimension().getWidth()) / 2,
				(TetrisDimension.SCREEN_DIMENSION.getHeight() - frameDimension().getHeight()) / 2);
	}

	/**
	 * @param pos
	 *            the original point of the frame.
	 * @param size
	 *            the size of the frame.
	 */
	public void setBounds(Point2D pos, Dimension size) {
		setSize(frameDimension());
		setLocation(originalPoint().toPoint());
	}

	public void updateTable() {
		// TODO Auto-generated method stub
		tableInfoPanel.updateTable();
	}

}
