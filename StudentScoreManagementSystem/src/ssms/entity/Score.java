package ssms.entity;

public class Score {
	
	private String studentId;
	private String studentName;
	private int chineseScore;
	private int mathScore;
	private int englishScore;
	
	public Score(String studentId, String studentName, int chineseScore, int mathScore, int englishScore) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.chineseScore = chineseScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
	}
		
	public Score(String studentId, int chineseScore, int mathScore, int englishScore) {
		super();
		this.studentId = studentId;
		this.chineseScore = chineseScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
	}

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getChineseScore() {
		return chineseScore;
	}

	public void setChineseScore(int chineseScore) {
		this.chineseScore = chineseScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	
}
