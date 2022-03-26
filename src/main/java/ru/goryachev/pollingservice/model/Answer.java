package ru.goryachev.pollingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

/**
 * Модель сущности "Ответ" (Answer)
 * @author Lev Goryachev
 * @version 1.0
 */

@Entity
@Table(name = "answer")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;

    @Column(name = "answer_body")
    private String answerBody;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = { "answer" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private Question question;

    @Column(name = "question_id")
    private Long questionId;

    public Long getAnswerId() {
        return answerId;
    }

    public void setId(Long id) {
        this.answerId = id;
    }

    public String getAnswerBody() {
        return answerBody;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer = (Answer) o;
        return Objects.equals(getAnswerId(), answer.getAnswerId()) &&
                Objects.equals(getAnswerBody(), answer.getAnswerBody()) &&
                Objects.equals(getQuestion(), answer.getQuestion()) &&
                Objects.equals(getQuestionId(), answer.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerId(), getAnswerBody(), getQuestion(), getQuestionId());
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerBody='" + answerBody + '\'' +
                ", question=" + question +
                ", questionId=" + questionId +
                '}';
    }
}
