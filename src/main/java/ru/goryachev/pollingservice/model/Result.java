package ru.goryachev.pollingservice.model;

import ru.goryachev.pollingservice.model.compositekey.ResultCompositeKey;

import javax.persistence.*;
import java.util.Objects;


/**
 * Модель сущности "Результат" (Result) - на связующую таблицу из трёх сущностей
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "spresult")
@IdClass(ResultCompositeKey.class)
public class Result {

    @Id
    @ManyToOne
    private AppUser appUser;

    @Id
    @ManyToOne
    private Question question;

    @Id
    @ManyToOne
    private Answer answer;

    public Result() {
    }

    public Result(AppUser appUser, Question question, Answer answer) {
        this.appUser = appUser;
        this.question = question;
        this.answer = answer;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return Objects.equals(getAppUser(), result.getAppUser()) &&
                Objects.equals(getQuestion(), result.getQuestion()) &&
                Objects.equals(getAnswer(), result.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppUser(), getQuestion(), getAnswer());
    }

    @Override
    public String toString() {
        return "Result{" +
                "appUser=" + appUser +
                ", question=" + question +
                ", answer=" + answer +
                '}';
    }
}
