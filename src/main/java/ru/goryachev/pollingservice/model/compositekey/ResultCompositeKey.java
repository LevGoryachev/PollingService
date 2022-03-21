package ru.goryachev.pollingservice.model.compositekey;

import java.io.Serializable;

/**
 * Класс композитного ключа для сущности Result
 * @author Lev Goryachev
 * @version 1.0
 */

public class ResultCompositeKey implements Serializable {

    Long appUser;

    Long question;

    Long answer;

    public ResultCompositeKey() {
    }

    public ResultCompositeKey(Long appUser, Long question, Long answer) {
        this.appUser = appUser;
        this.question = question;
        this.answer = answer;
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
