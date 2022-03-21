package ru.goryachev.pollingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.pollingservice.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository <AppUser, Long> {

}
