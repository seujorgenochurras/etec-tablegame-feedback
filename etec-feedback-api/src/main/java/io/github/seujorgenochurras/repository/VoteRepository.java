package io.github.seujorgenochurras.repository;

import io.github.seujorgenochurras.domain.board.BoardGame;
import io.github.seujorgenochurras.domain.Vote;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    List<Vote> findVotesByBoardGame(BoardGame boardGame);

    @Query(value = "select AVG(v.feeback) from vote v where v.boardGameFk = ?1", nativeQuery = true)
    Double getAvgFeedBack(@Valid BoardGame boardGame);

}
