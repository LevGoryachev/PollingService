package ru.goryachev.pollingservice.model;


import ru.goryachev.pollingservice.model.compositekey.ResultCompositeKey;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Модель сущности "Результат опроса" (SpResult) - на связующую таблицу из трёх сущностей
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "spresult")
@IdClass(ResultCompositeKey.class)
public class SpResult implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "app_user_id", insertable = false, updatable = false)
    private AppUser appUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;

    @Id
    @ManyToOne
    @JoinColumn(name = "answer_id", insertable = false, updatable = false)
    private Answer answer;

    @Column(name = "result_time")
    private LocalDateTime resultTime;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public LocalDateTime getResultTime() {
        return resultTime;
    }

    public void setResultTime(LocalDateTime resultTime) {
        this.resultTime = resultTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpResult)) return false;
        SpResult that = (SpResult) o;
        return Objects.equals(getAppUser(), that.getAppUser()) &&
                Objects.equals(getQuestion(), that.getQuestion()) &&
                Objects.equals(getAnswer(), that.getAnswer()) &&
                Objects.equals(getResultTime(), that.getResultTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppUser(), getQuestion(), getAnswer(), getResultTime());
    }

    @Override
    public String toString() {
        return "SpResult{" +
                "appUser=" + appUser +
                ", question=" + question +
                ", answer=" + answer +
                ", resultTime=" + resultTime +
                '}';
    }
}
