package ssms.ui;

/**
 * 
 * @author VULCAN
 * 
 * @Project StudentScoreManagementSystem
 *
 * @CreateTime 2019年12月29日 下午10:56:55
 *
 */
public class UpdateStudentInfoFrame extends StudentInfoFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentInfoPanel studentInfoPanel;

	/**
	 * Constructor.
	 * 
	 * @param mainFrame
	 */
	public UpdateStudentInfoFrame(MainFrame mainFrame) {
		super(mainFrame);
		// TODO Auto-generated constructor stub
	}

	/**
	 * StudentInfoPanel.
	 */
	public StudentInfoPanel studentInfoPanel() {
		if (studentInfoPanel == null)
			studentInfoPanel = new UpdateStudentInfoPanel();
		return studentInfoPanel;
	}

	/**
	 * Fill Fields.
	 */
	public void fillFields() {
		((UpdateStudentInfoPanel) studentInfoPanel()).fillFields();
	}
}
