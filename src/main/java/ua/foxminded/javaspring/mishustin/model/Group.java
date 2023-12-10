package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Group")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer groupId;

	private String groupName;

	@OneToMany(mappedBy = "group")
	private List<Student> students;


	public Group() {
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
