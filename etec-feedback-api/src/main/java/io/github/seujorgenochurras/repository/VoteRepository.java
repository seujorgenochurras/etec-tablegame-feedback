package io.github.seujorgenochurras.repository;

import io.github.seujorgenochurras.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    List<Vote> findByVoteClass(String voteClass);

    @Query("select distinct tablegame from Vote")
    List<String> findDintinct();

    @Query("select AVG(e.feedback) from Vote e where tablegame =?1 group by e.tablegame")
    Double findAverageFeedbackByTablegame(String tablegame);

}
