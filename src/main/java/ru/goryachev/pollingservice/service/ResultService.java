package ru.goryachev.pollingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.pollingservice.exception.KeyPropertiesNotFoundException;
import ru.goryachev.pollingservice.model.SpResult;
import ru.goryachev.pollingservice.repository.ResultRepository;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Сервис слой "Результат опроса" (SpResult)
 * Получаем HashMap с параметрами запроса и фильтруем результаты в общий возвращаемый список в зависимости от этих параметров
 * @author Lev Goryachev
 * @version 1.0
 */

@Service
public class ResultService {

    private ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Object> getAll(Map<String, Long> params){
        List<Object> results = new ArrayList<>() {};
        if(params.isEmpty() || (params.get("userId")==null && params.get("questionId")==null && params.get("pollId")==null)) {
            results.addAll(resultRepository.findAll());
            return results;
        }
        if(params.get("userId")!=null){
            results.addAll(resultRepository.findByAppUserAppUserId(params.get("userId")));
        }
        if(params.get("questionId")!=null){
            results.addAll(resultRepository.findByQuestionQuestionId(params.get("questionId")));
        }
        if(params.get("pollId")!=null){
            results.addAll(resultRepository.findByQuestionPollId(params.get("pollId")));
        }
        return results;
    }

    public SpResult save(SpResult spResult) {

        if(spResult.getAppUser()==null || spResult.getAppUser().getAppUserId()==null || spResult.getQuestion()==null || spResult.getQuestion().getQuestionId()==null || spResult.getAnswer()==null || spResult.getAnswer().getAnswerId()==null){
            List<String> undetectedProps = new ArrayList<>();
            if(spResult.getAppUser()==null || spResult.getAppUser().getAppUserId()==null){
                undetectedProps.add("appUserId");
            }
            if(spResult.getQuestion()==null || spResult.getQuestion().getQuestionId()==null){
                undetectedProps.add("questionId");
            }
            if(spResult.getAnswer()==null || spResult.getAnswer().getAnswerId()==null){
                undetectedProps.add("answerId");
            }
            throw new KeyPropertiesNotFoundException(undetectedProps);
        }
        if(spResult.getResultTime()==null){
            spResult.setResultTime(LocalDateTime.now());
        }
        return resultRepository.save(spResult);
    }
}
