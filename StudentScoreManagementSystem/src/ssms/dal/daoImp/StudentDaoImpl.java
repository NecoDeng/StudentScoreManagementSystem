package ssms.dal.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ssms.dal.DBUtil;
import ssms.dal.dao.StudentDao;
import ssms.entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean addStudent(Student stu) {
		String insert = "insert into student(id,name,age,gender,className) values('" + stu.getId() + "','"
				+ stu.getName() + "'," + stu.getAge() + ",'" + stu.getGender() + "','" + stu.getClassName() + "')";
		try {
			DBUtil.runUpdate(insert);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student stu) {
		String update = "update student set name='" + stu.getName() + "',age=" + stu.getAge() + ",gender='"
				+ stu.getGender() + "',className='" + stu.getClassName() + "' where id='" + stu.getId() + "'";
		try {
			DBUtil.runUpdate(update);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public Student getStudentbyID(String id) {
		String select = "select * from student where id = '" + id + "'";
		try {
			Student student = new Student();
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setGender(rs.getString("gender"));
				student.setClassName(rs.getString("className"));
				break;
			}
			DBUtil.realeaseAll();
			return student;
		} catch (SQLException ex) {
			Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null; // To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Student> getStudentbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		String select = "select * from student";
		try {
			List<Student> students = new ArrayList<Student>();
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setGender(rs.getString("gender"));
				student.setClassName(rs.getString("className"));
				students.add(student);
			}
			DBUtil.realeaseAll();
			return students;
		} catch (SQLException ex) {
			Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null; // To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean delStudentbyID(String id) {
		String delete = "delete from student where id = '" + id + "'";

		try {
			DBUtil.runUpdate(delete);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public List<Student> getAllStudentByIdAndNameAndClass(String id, String name, String className) {
		if(id == null) id = "";
		if(name == null) name = "";
		if(className == null) className = "";
		String select = "select * from student where id like '%" + id + "%' and name like '%" + name + "%' and className like '%" + className + "%'";
		try {
			List<Student> students = new ArrayList<Student>();
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setGender(rs.getString("gender"));
				student.setClassName(rs.getString("className"));
				students.add(student);
			}
			DBUtil.realeaseAll();
			return students;
		} catch (SQLException ex) {
			Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null; // To change body of generated methods, choose Tools | Templates.
	}

}
