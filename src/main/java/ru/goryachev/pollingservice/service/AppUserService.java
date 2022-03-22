package ru.goryachev.pollingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.pollingservice.model.AppUser;
import ru.goryachev.pollingservice.repository.AppUserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AppUserService {

    private AppUserRepository appuserRepository;

    @Autowired
    public AppUserService(AppUserRepository appuserRepository) {
        this.appuserRepository = appuserRepository;
    }

    public List<AppUser> getAll(){
        return appuserRepository.findAll();
    }

    public AppUser getById(Long id){
        return appuserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID " + id + " not found"));
    }

    public AppUser save(AppUser appuser) {
        return appuserRepository.save(appuser);
    }

    public String delete (Long id) {
        appuserRepository.deleteById(id);
        return "Entity with id " + id + " was deleted";
    }
}
