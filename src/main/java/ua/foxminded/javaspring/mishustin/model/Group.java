package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "group")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer groupId;

	@Column(length = 50)
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
