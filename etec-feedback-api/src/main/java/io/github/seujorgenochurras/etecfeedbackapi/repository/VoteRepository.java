package io.github.seujorgenochurras.etecfeedbackapi.repository;

import io.github.seujorgenochurras.etecfeedbackapi.domain.Vote;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    List<Vote> findByVoteClass(String voteClass);

    @Query("select AVG(e.feedback) from Vote e where e.tablegame = ?1")
    Double findAverageFeedbackByTablegame(String tablegame);

}
