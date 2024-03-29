package ru.goryachev.pollingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.pollingservice.model.Question;
import ru.goryachev.pollingservice.repository.QuestionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Сервис слой "Вопрос" (Question)
 * @author Lev Goryachev
 * @version 1.0
 */

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }

    public List<Question> getAllByPollId(Long pollId, Boolean isSelector){
        return questionRepository.findAllByPollIdAndIsSelector(pollId, isSelector);
    }

    public Question getById(Long id){
        return questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID " + id + " not found"));
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public String delete (Long id) {
        questionRepository.deleteById(id);
        return "Entity with id " + id + " was deleted";
    }
}
