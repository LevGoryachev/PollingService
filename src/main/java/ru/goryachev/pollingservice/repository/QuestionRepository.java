package ru.goryachev.pollingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.pollingservice.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Long> {
    List<Question> findAllByPollIdAndIsSelector(Long pollId, Boolean isSelector);
}
