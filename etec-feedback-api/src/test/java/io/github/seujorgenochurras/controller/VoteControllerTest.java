package io.github.seujorgenochurras.controller;

import io.github.seujorgenochurras.domain.FeedBack;
import io.github.seujorgenochurras.domain.Vote;
import io.github.seujorgenochurras.dto.VoteDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(VoteController.class)
@SpringBootTest
public class VoteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private VoteController voteController;

    @Value(value = "${local.server.port}")
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void isSavingVote() throws Exception {
        VoteDto voteDto = new VoteDto();
        voteDto.setBoardGameId(1)
                .setFeedBack(FeedBack.ACCEPTABLE)
                .setVoterName("Jhon");

        mockMvc.perform(post("/register/vote", voteDto)).andDo(print()).andExpect(status().isCreated());
    }
}
