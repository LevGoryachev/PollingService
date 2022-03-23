package ru.goryachev.pollingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.pollingservice.model.Answer;
import ru.goryachev.pollingservice.repository.AnswerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Сервис слой "Ответ" (Answer)
 * @author Lev Goryachev
 * @version 1.0
 */

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll(){
        return answerRepository.findAll();
    }

    public List<Answer> getAllByQuestionId(Long questionId){
        return answerRepository.findAllByQuestionId(questionId);
    }

    public Answer getById(Long id){
        return answerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID " + id + " not found"));
    }

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    public String delete (Long id) {
        answerRepository.deleteById(id);
        return "Entity with id " + id + " was deleted";
    }
}
