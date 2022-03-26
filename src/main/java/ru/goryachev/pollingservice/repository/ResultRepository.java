package ru.goryachev.pollingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.pollingservice.model.SpResult;
import ru.goryachev.pollingservice.model.dto.projection.ItemProjection;

import java.util.List;

/**
 * Интерфейс предполагается ипользовать для получения различных проекций DTO (SpResult).
 * Например, если нужна выборка определенных полей из объекта SpResult, то:
 * - написать необходимый интерфейс проекции ExampleProjection;
 * - описать здесь метод JPQL, возвращающий тип ExampleProjection (нужная выборка);
 * @author Lev Goryachev
 * @version 1
 */

@Repository
public interface ResultRepository extends JpaRepository <SpResult, Long> {
    List<ItemProjection> findByAppUserAppUserId(Long userId);
    List<ItemProjection> findByQuestionQuestionId(Long questionId);
    List<ItemProjection> findByQuestionPollId(Long pollId);
}
