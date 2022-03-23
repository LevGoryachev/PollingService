package ru.goryachev.pollingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.pollingservice.model.Answer;
import ru.goryachev.pollingservice.model.Question;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository <Answer, Long> {
    List<Answer> findAllByQuestionId(Long questionId);
}
