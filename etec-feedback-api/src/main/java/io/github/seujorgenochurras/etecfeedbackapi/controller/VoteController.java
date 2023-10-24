package io.github.seujorgenochurras.etecfeedbackapi.controller;

import io.github.seujorgenochurras.etecfeedbackapi.domain.Vote;
import io.github.seujorgenochurras.etecfeedbackapi.repository.VoteRepository;
import io.github.seujorgenochurras.etecfeedbackapi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/vote")
    public ResponseEntity<Vote> vote(@RequestBody Vote vote) {
        return new ResponseEntity<>(voteService.save(vote), HttpStatus.OK);
    }

    @GetMapping("/feedback/ds1")
    public ResponseEntity<String> getFeedback() {
        List<Vote> averageVotes = voteService.getVotesAverageByClass("ds1");
        StringBuilder votes = new StringBuilder();

        averageVotes.forEach(vote -> {
            votes.append("<div>" + vote.tablegame() + "  : " + vote.feedback());
        });
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>De seu feedback!</title>\n" +
                "    <link rel=\"stylesheet\" href=\"index.css\">\n" +
                "    <script>var exports = {};</script>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div class=\"feed-layout\">\n" +
                "        <h1 class=\"feed-text\">Leaderboard do 1 DS</h1>\n" +
                "        <div class=\"feed-pages\" style=\"font-size: 22px;\">\n" +
                votes +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "</body>\n" +
                "<script src=\"main.js\"></script>\n" +
                "\n" +
                "</html>";
        return new ResponseEntity<>(html, HttpStatus.OK);
    }
}
