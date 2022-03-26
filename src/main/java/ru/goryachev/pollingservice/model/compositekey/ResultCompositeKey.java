package ru.goryachev.pollingservice.model.compositekey;

import java.io.Serializable;

/**
 * Класс композитного ключа для сущности SpResult
 * @author Lev Goryachev
 * @version 1.0
 */

public class ResultCompositeKey implements Serializable {

    private Long appUser;

    private Long question;

    private Long answer;

    public ResultCompositeKey() {
    }

    public ResultCompositeKey(Long appUserId, Long questionId, Long answerId) {
        this.appUser = appUserId;
        this.question = questionId;
        this.answer = answerId;
    }

    public Long getAppUser() {
        return appUser;
    }

    public void setAppUser(Long appUser) {
        this.appUser = appUser;
    }

    public Long getQuestion() {
        return question;
    }

    public void setQuestion(Long question) {
        this.question = question;
    }

    public Long getAnswer() {
        return answer;
    }

    public void setAnswer(Long answer) {
        this.answer = answer;
    }
}
