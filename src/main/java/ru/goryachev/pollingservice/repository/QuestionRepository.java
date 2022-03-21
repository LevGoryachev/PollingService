package ru.goryachev.pollingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.pollingservice.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Long> {

}
