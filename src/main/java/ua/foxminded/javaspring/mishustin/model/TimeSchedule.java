package ua.foxminded.javaspring.mishustin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "time_schedule")
public class TimeSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_schedule_id")
    private Integer timeScheduleId;

    @Column(name = "time_period", length = 20, nullable = false, unique = true)
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

	@Override
	public String toString() {
		return timePeriod;
	}
}
