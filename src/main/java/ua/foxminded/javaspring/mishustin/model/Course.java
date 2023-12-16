package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;

	@Column(length = 255)
	private String courseName;

	@OneToOne(mappedBy = "course")
	private Teacher teacher;

	public Course() {
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
