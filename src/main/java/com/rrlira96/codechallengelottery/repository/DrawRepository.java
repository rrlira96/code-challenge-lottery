package com.rrlira96.codechallengelottery.repository;

import com.rrlira96.codechallengelottery.entities.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrawRepository extends JpaRepository<Draw, Integer> {
    @Query(value = "SELECT * FROM lottery_draws WHERE seq_number = 0", nativeQuery = true)
    List<Draw> findAllBySeqNum();

}
