package io.github.seujorgenochurras.service;

import io.github.seujorgenochurras.domain.board.BoardGame;
import io.github.seujorgenochurras.domain.Vote;
import io.github.seujorgenochurras.exception.NotFoundException;
import io.github.seujorgenochurras.repository.BoardGameRepository;
import io.github.seujorgenochurras.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardGameService {

    @Autowired
    private BoardGameRepository boardGameRepository;

    @Autowired
    private VoteRepository voteRepository;

    public BoardGame save(BoardGame boardGame){
       return boardGameRepository.save(boardGame);
    }

    public List<Vote> getVotes(BoardGame boardGame){
        return voteRepository.findVotesByBoardGame(boardGame);
    }

    public double getAverageVotes(BoardGame boardGame){
        return voteRepository.getAvgFeedBack(boardGame);
    }

    public BoardGame getBoardGameById(int id){
        return boardGameRepository.findById(id).orElseThrow(() -> new NotFoundException("board game " + id + " was not found"));
    }

}
