package ru.goryachev.pollingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.pollingservice.model.Result;
import ru.goryachev.pollingservice.model.dto.projection.ItemProjection;
import ru.goryachev.pollingservice.repository.ResultRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ResultService {

    private ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<ItemProjection> getAllByUserId(Long userId){
        return resultRepository.findAllByAppUserId(userId);
    }

    public Result getById(Long id){
        return resultRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID " + id + " not found"));
    }

    public Result save(Result result) {
        return resultRepository.save(result);
    }

    public String delete (Long id) {
        resultRepository.deleteById(id);
        return "Entity with id " + id + " was deleted";
    }
}
