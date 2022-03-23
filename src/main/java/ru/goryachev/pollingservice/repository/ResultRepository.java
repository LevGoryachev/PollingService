package ru.goryachev.pollingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.pollingservice.model.Result;
import ru.goryachev.pollingservice.model.dto.projection.ItemProjection;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository <Result, Long> {
    List<ItemProjection> findAllByAppUserId(Long userId);
}
