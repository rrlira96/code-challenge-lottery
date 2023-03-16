package com.rrlira96.codechallengelottery.repository;

import com.rrlira96.codechallengelottery.entities.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Integer> {
}
