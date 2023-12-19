package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends User {

	@OneToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@Column(length = 20, nullable = false)
	private Integer room;

    public Teacher() {
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
