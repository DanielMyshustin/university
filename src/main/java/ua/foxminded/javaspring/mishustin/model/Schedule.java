package ua.foxminded.javaspring.mishustin.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "schedule_date")
    private LocalDate scheduleDate;

    @OneToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course courseId;

    @OneToOne
    @JoinColumn(name = "time_schedule_id", nullable = false)
    private TimeSchedule timeScheduleId;

    public Schedule() {
    }

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public LocalDate getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public TimeSchedule getTimeScheduleId() {
		return timeScheduleId;
	}

	public void setTimeScheduleId(TimeSchedule timeScheduleId) {
		this.timeScheduleId = timeScheduleId;
	}
}
