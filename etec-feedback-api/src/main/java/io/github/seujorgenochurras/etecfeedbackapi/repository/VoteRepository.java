package io.github.seujorgenochurras.etecfeedbackapi.repository;

import io.github.seujorgenochurras.etecfeedbackapi.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

}
