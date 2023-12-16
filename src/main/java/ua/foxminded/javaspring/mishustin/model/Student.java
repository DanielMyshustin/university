package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student extends User {

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

    public Student() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
