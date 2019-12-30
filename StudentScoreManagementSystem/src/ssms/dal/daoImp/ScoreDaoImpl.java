package ssms.dal.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ssms.dal.DBUtil;
import ssms.dal.dao.ScoreDao;
import ssms.entity.Score;

public class ScoreDaoImpl implements ScoreDao {

	@Override
	public boolean addScore(Score score) {
		String insert = "insert into score(studentId,chineseScore,mathScore,englishScore) values('"
				+ score.getStudentId() + "','" + score.getChineseScore() + "'," + score.getMathScore() + ",'"
				+ score.getEnglishScore() + "')";
		try {
			DBUtil.runUpdate(insert);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(ScoreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public boolean updateScore(Score score) {
		String update = "update score set chineseScore=" + score.getChineseScore() + ",mathScore="
				+ score.getMathScore() + ",englishScore=" + score.getEnglishScore() + " where studentId='"
				+ score.getStudentId() + "'";
		try {
			System.out.println(update);
			DBUtil.runUpdate(update);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(ScoreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public Score getScoreByStudentId(String studentId) {
		String select = "select id as studentId, name as studentName, coalesce(chineseScore, -1) as chineseScore, coalesce(mathScore, -1) as mathScore, "
				+ "coalesce(englishScore, -1) as englishScore from student left join score on score.studentId = student.id and score.studentId='"
				+ studentId + "'";
		System.out.println(select);
		try {
			Score score = new Score();
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				score.setStudentId(rs.getString("studentId"));
				score.setStudentName(rs.getString("studentName"));
				score.setChineseScore(rs.getInt("chineseScore"));
				score.setMathScore(rs.getInt("mathScore"));
				score.setEnglishScore(rs.getInt("englishScore"));
				break;
			}
			DBUtil.realeaseAll();
			return score;
		} catch (SQLException ex) {
			Logger.getLogger(ScoreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public List<Score> getAllScore() {

		String select = "select id as studentId, name as studentName, coalesce(chineseScore, -1) as chineseScore, coalesce(mathScore, -1) as mathScore,"
				+ " coalesce(englishScore, -1) as englishScore from student left join score on score.studentId = student.id";
		try {
			System.out.println(select);
			List<Score> scores = new ArrayList<Score>();
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				Score score = new Score();
				score.setStudentId(rs.getString("studentId"));
				score.setStudentName(rs.getString("studentName"));
				score.setChineseScore(rs.getInt("chineseScore"));
				score.setMathScore(rs.getInt("mathScore"));
				score.setEnglishScore(rs.getInt("englishScore"));
				scores.add(score);
			}
			DBUtil.realeaseAll();
			return scores;
		} catch (SQLException ex) {
			Logger.getLogger(ScoreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null; // To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Score> getAllScoreByIdAndName(String id, String name) {
		if(id == null) id = "";
		if(name == null) name = "";
		String select = "select id as studentId, name as studentName, coalesce(chineseScore, -1) as chineseScore, coalesce(mathScore, -1) as mathScore,"
				+ " coalesce(englishScore, -1) as englishScore from student left join score on score.studentId = student.id where id like '%"
				+ id +"%' and name like '%" + name +"%'";
		try {
			System.out.println(select);
			List<Score> scores = new ArrayList<Score>();
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				Score score = new Score();
				score.setStudentId(rs.getString("studentId"));
				score.setStudentName(rs.getString("studentName"));
				score.setChineseScore(rs.getInt("chineseScore"));
				score.setMathScore(rs.getInt("mathScore"));
				score.setEnglishScore(rs.getInt("englishScore"));
				scores.add(score);
			}
			DBUtil.realeaseAll();
			return scores;
		} catch (SQLException ex) {
			Logger.getLogger(ScoreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null; // To change body of generated methods, choose Tools | Templates.
	}

}
