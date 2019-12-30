package ssms.ui;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;

public class StudentInfoFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param mainFrame
	 */
	public StudentInfoFrame(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super(mainFrame);
		try {
			initFrame();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Constructor.
	 */
	public StudentInfoFrame() {
		// TODO Auto-generated constructor stub
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
		getContentPane().add(studentInfoPanel());
		fillFields();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);
	}

	
	public void fillFields() {
	
	}
	
	/**
	 * @return Current Frame Dimension.
	 */
	private Dimension frameDimension() {
		return new Dimension(450, 450);
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

	/**
	 * StudentInfoPanel
	 * @return StudentInfoPanel
	 */
	public StudentInfoPanel studentInfoPanel() {
		return new InsertStudentInfoPanel();
	}

}
