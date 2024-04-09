package com.codingbox.jpaitem.relration.repository;

import com.codingbox.jpaitem.relration.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findById(Long id);
}