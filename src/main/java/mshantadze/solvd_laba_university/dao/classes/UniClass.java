package mshantadze.solvd_laba_university.dao.classes;

public class UniClass {
	private int classId;
	private String name;
	private String description;
	private String level;
	private int departmentId;
	
	public UniClass(int classId, String name, String description, String level, int departmentId) {
		this.classId = classId;
		this.name = name;
		this.description = description;
		this.level = level;
		this.departmentId = departmentId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
