package ru.goryachev.pollingservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.pollingservice.model.Answer;
import ru.goryachev.pollingservice.repository.AnswerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;
    private final Logger log = LoggerFactory.getLogger(AnswerService.class);

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll(){
        return answerRepository.findAll();
    }

    public Answer getById(Long id){
        log.info("AnswerService: got one by ID)");
        return answerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID " + id + " not found"));
    }

    public Answer save(Answer answer) {
        //log.info("AddressService create(address)");
        return answerRepository.save(answer);
    }

    public void delete(Long id) {
        //log.info("AddressService delete(id)");
        answerRepository.deleteById(id);
    }
}
