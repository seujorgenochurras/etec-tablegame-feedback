package io.github.seujorgenochurras.controller;

import com.google.gson.Gson;
import io.github.seujorgenochurras.assemble.BoardGameAssembler;
import io.github.seujorgenochurras.domain.FeedBack;
import io.github.seujorgenochurras.dto.BoardGameDto;
import io.github.seujorgenochurras.dto.VoteDto;
import io.github.seujorgenochurras.service.BoardGameService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Base64;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BoardGameController.class)
public class BoardGameControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoardGameService boardGameService;

    @MockBean
    private BoardGameAssembler boardGameAssembler;

    @Test
    void isSavingVote() throws Exception {
        Gson gson = new Gson();

        File randomImage = new File("/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png");
        BoardGameDto boardGameDto = new BoardGameDto()
                .setLogo(new MockMultipartFile(
                        "fuckYeah",
                        "fuckYeah.png",
                        MediaType.ALL_VALUE,
                        Base64.getEncoder().encode(Files.readAllBytes(randomImage.toPath()))
                ))
                .setMap(new MockMultipartFile(
                        "fuckYeah",
                        "fuckYeah.png",
                        MediaType.IMAGE_PNG_VALUE,
                        Base64.getEncoder().encode(Files.readAllBytes(randomImage.toPath()))))
                .setName("Nah");

        mockMvc.perform(post("/register/boardgame")
                        .contentType(MediaType.IMAGE_PNG_VALUE)
                        .content(gson.toJson(boardGameDto))
                )
                .andDo(print()).andExpect(status().isCreated());
    }
}
