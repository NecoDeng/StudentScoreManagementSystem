package ssms.dal.dao;

import java.util.List;

import ssms.entity.Score;

public interface ScoreDao {
    public boolean addScore(Score score);
    
    public boolean updateScore(Score score);
    
    public Score getScoreByStudentId(String studentId);
    
    public List<Score> getAllScore();
    
    public List<Score> getAllScoreByIdAndName(String id, String name);

}
