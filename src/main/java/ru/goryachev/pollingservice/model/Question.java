package ru.goryachev.pollingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

/**
 * Модель сущности "Вопрос" (Question)
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "question")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "question_body")
    private String questionBody;

    @Column(name = "is_selector")
    private Boolean isSelector;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "poll_id", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = { "question" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private Poll poll;

    @Column(name = "poll_id")
    private Long pollId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public Boolean getSelector() {
        return isSelector;
    }

    public void setSelector(Boolean selector) {
        isSelector = selector;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(getId(), question.getId()) &&
                Objects.equals(getQuestionBody(), question.getQuestionBody()) &&
                Objects.equals(isSelector, question.isSelector) &&
                Objects.equals(getPoll(), question.getPoll()) &&
                Objects.equals(getPollId(), question.getPollId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestionBody(), isSelector, getPoll(), getPollId());
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionBody='" + questionBody + '\'' +
                ", isSelector=" + isSelector +
                ", poll=" + poll +
                ", pollId=" + pollId +
                '}';
    }
}
