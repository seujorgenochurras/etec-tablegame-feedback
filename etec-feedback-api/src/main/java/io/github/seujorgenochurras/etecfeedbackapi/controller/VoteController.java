package io.github.seujorgenochurras.etecfeedbackapi.controller;

import io.github.seujorgenochurras.etecfeedbackapi.domain.Vote;
import io.github.seujorgenochurras.etecfeedbackapi.repository.VoteRepository;
import io.github.seujorgenochurras.etecfeedbackapi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    @Autowired
    private VoteService voteService;
    @PostMapping("/vote")
    public ResponseEntity<Vote> vote(@RequestBody Vote vote){
        return new ResponseEntity<>(voteService.save(vote), HttpStatus.OK);
    }
}
