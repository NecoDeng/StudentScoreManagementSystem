package ssms.entity;

public class Student {
	
	private int age;
	private String id;	
	private String name;
	private String gender;
	private String className;
	
	
	
	public Student(String id, int age, String name, String gender, String className) {
		super();
		this.age = age;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.className = className;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
