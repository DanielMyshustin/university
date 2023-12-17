package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scheduleId;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	private LocalDate scheduleDate;

	@OneToOne
	@JoinColumn(name = "course_id")
	private Course courseId;

	@OneToOne
	@JoinColumn(name = "time_schedule_id")
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
