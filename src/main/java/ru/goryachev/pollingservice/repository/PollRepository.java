package ru.goryachev.pollingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.pollingservice.model.Poll;

@Repository
public interface PollRepository extends JpaRepository <Poll, Long> {

}
