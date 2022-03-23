package ru.goryachev.pollingservice.model.dto.projection;
/**
 * ItemView - DTO projection for ResponseDTOs
 * @author Lev Goryachev
 * @version 1.0
 */
public interface ItemProjection {
    AppUserProjection getAppUser();
    QuestionProjection getQuestion();
    AnswerProjection getAnswer();
}
