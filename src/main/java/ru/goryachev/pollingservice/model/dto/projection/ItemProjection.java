package ru.goryachev.pollingservice.model.dto.projection;

import java.time.LocalDateTime;

/**
 * Проекция DTO для выборки из объекта SpResult результатов опроса определенного пользователя
 * @author Lev Goryachev
 * @version 1.0
 */
public interface ItemProjection {
    AppUserProjection getAppUser();
    QuestionProjection getQuestion();
    AnswerProjection getAnswer();
    LocalDateTime getResultTime();
}
