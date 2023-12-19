package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "timeSchedule")
public class TimeSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timeScheduleId;

	@Column(length = 20, nullable = false)
	private String timePeriod;

    public TimeSchedule() {
    }

    public int getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(int timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }
}
