package ru.goryachev.pollingservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.pollingservice.model.Poll;
import ru.goryachev.pollingservice.repository.PollRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PollService {

    private PollRepository pollRepository;
    private final Logger log = LoggerFactory.getLogger(PollService.class);

    @Autowired
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> getAll(){
        return pollRepository.findAll();
    }

    public Poll getById(Long id){
        log.info("PollService: got one by ID)");
        return pollRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID " + id + " not found"));
    }

    public Poll save(Poll poll) {
        //log.info("AddressService create(address)");
        return pollRepository.save(poll);
    }

    public String delete (Long id) {
        //log.info("AddressService delete(id)");
        pollRepository.deleteById(id);
        return "Entity with id " + id + " was deleted";
    }
}