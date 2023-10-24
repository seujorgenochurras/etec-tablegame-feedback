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
                "    <style> body {\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "    border: 0;\n" +
                "    font-size: 100%;\n" +
                "    font: inherit;\n" +
                "    vertical-align: baseline;\n" +
                "    background-color: bisque;\n" +
                "    font-family: Arial, Helvetica, sans-serif;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".feed-layout {\n" +
                "    background-color: white;\n" +
                "    width: 1200px;\n" +
                "    height: 760px;\n" +
                "\n" +
                "    top: 50%;\n" +
                "    left: 50%;\n" +
                "    position: absolute;\n" +
                "    transform: translate(-50%, -50%);\n" +
                "    border-radius: 20px;\n" +
                "    border-width: 2px;\n" +
                "    padding: 30px;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "\n" +
                "    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15);\n" +
                "}\n" +
                "\n" +
                ".feed-text {\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                ".feed-page {\n" +
                "    background-color: #ccc;\n" +
                "    color: #fff;\n" +
                "    border-radius: 19px;\n" +
                "    font-size: 50px;\n" +
                "    padding: 10.5px 15.3px;\n" +
                "    border-style: solid;\n" +
                "    border: 0px;\n" +
                "    text-decoration: none;\n" +
                "    color: #000;\n" +
                "    bottom: 220px;\n" +
                "}\n" +
                ".feed-pages {\n" +
                "    display: flex;\n" +
                "    justify-content: space-between;\n" +
                "    margin-top: 50px;\n" +
                "}\n" +
                "}</style>" +
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
