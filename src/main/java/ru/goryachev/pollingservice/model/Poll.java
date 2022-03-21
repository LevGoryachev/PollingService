package ru.goryachev.pollingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Модель сущности "Опрос" (Poll)
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "poll")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "finish_time")
    private LocalDateTime finishTime;

    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poll)) return false;
        Poll poll = (Poll) o;
        return Objects.equals(getId(), poll.getId()) &&
                Objects.equals(getName(), poll.getName()) &&
                Objects.equals(getStartTime(), poll.getStartTime()) &&
                Objects.equals(getFinishTime(), poll.getFinishTime()) &&
                Objects.equals(getDescription(), poll.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStartTime(), getFinishTime(), getDescription());
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", description='" + description + '\'' +
                '}';
    }
}
