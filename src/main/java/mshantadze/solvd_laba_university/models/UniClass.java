package mshantadze.solvd_laba_university.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name="class")
@XmlAccessorType(XmlAccessType.FIELD)
public class UniClass {
	@XmlAttribute(name="id")
	private int classId;
	@XmlElement
	private String name;
	@XmlElement
	private String description;
	@XmlElement
	private String level;
	@XmlElement
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
