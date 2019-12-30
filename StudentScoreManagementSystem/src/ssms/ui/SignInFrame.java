package ssms.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class SignInFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor.
	 */
	public SignInFrame() {
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
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));		
		getContentPane().add(new SignInPanel());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//getContentPane().add(new MenuPanel());
		setVisible(true);
	}

	/**
	 * @return Current Frame Dimension.
	 */
	private Dimension frameDimension() {
		return new Dimension(450, 350);
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

}
