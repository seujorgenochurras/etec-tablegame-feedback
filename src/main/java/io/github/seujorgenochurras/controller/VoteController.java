package io.github.seujorgenochurras.controller;

import io.github.seujorgenochurras.assemble.VoteAssembler;
import io.github.seujorgenochurras.domain.Vote;
import io.github.seujorgenochurras.dto.VoteDto;
import io.github.seujorgenochurras.service.VoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VoteController {

    @Autowired
    private VoteAssembler voteAssembler;

    @Autowired
    private VoteService voteService;


    @PostMapping("/register/vote")
    public ResponseEntity<Vote> registerVote(@RequestBody @Valid VoteDto voteDTO){
        Vote voteEntity = voteAssembler.toEntity(voteDTO);
        Vote persistedVote = voteService.save(voteEntity);

        return new ResponseEntity<>(persistedVote, HttpStatus.CREATED);
    }

}
