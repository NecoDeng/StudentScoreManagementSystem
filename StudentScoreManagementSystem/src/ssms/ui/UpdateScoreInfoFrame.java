package ssms.ui;


public class UpdateScoreInfoFrame extends ScoreInfoFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param mainFrame
	 */
	public UpdateScoreInfoFrame(MainFrame mainFrame) {
		super(mainFrame);
	}
	
	/**
	 * ScoreInfoPanel.
	 */
	public ScoreInfoPanel scoreInfoPanel() {
		if(scoreInfoPanel == null) scoreInfoPanel = new UpdateScoreInfoPanel();
		return scoreInfoPanel;
	}

}
