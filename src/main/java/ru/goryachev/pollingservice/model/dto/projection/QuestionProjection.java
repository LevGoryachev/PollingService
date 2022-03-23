package ru.goryachev.pollingservice.model.dto.projection;
/**
 * MaterialView - DTO projection for ResponseDTOs
 * @author Lev Goryachev
 * @version 1.1
 */
public interface QuestionProjection {
    Long getId();
    String getQuestionBody();
    String getPollId();
}
