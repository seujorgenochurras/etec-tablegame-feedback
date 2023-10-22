package io.github.seujorgenochurras.controller;

import io.github.seujorgenochurras.assemble.BoardGameAssembler;
import io.github.seujorgenochurras.domain.board.BoardGame;
import io.github.seujorgenochurras.dto.BoardGameDto;
import io.github.seujorgenochurras.dto.FeedbackDto;
import io.github.seujorgenochurras.service.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
public class BoardGameController {

    @Autowired
    private BoardGameService boardGameService;

    @Autowired
    private BoardGameAssembler boardGameAssembler;

    @PostMapping(value = "register/boardgame", consumes = { MediaType.ALL_VALUE})
    public ResponseEntity<BoardGame> registerBoardGame(@RequestBody BoardGameDto boardGameDto){
        BoardGame boardGame = boardGameService.save(boardGameAssembler.toEntity(boardGameDto));
        return new ResponseEntity<>(boardGame, HttpStatus.CREATED);
    }

    @GetMapping("boardgame/votes")
    public ResponseEntity<FeedbackDto> getVotes(@RequestBody int boardGameId){
        BoardGame boardGame = boardGameService.getBoardGameById(boardGameId);
        FeedbackDto feedbackDto = new FeedbackDto()
                .setBoardGame(boardGame)
                .setAverageVotes(boardGameService.getAverageVotes(boardGame));
        return new ResponseEntity<>(feedbackDto, HttpStatus.OK);
    }


}
