package io.github.seujorgenochurras;

import com.google.gson.Gson;
import io.github.seujorgenochurras.dto.BoardGameDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class GsonTest {
    @Test
    void printBoardGameDto() throws IOException {
        Gson gson = new Gson();
        File randomImage = new File("/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png");
        BoardGameDto boardGameDto = new BoardGameDto()
                .setLogo(new MockMultipartFile(
                        "fuckYeah",
                        "fuckYeah.png",
                        MediaType.IMAGE_PNG_VALUE,
                        Files.readAllBytes(randomImage.toPath())
                ))
                .setMap(new MockMultipartFile(
                        "fuckYeah",
                        "fuckYeah.png",
                        MediaType.IMAGE_PNG_VALUE,
                        Files.readAllBytes(randomImage.toPath())))
                .setName("Nah");

        FileWriter fileWriter = new FileWriter("idk.txt");
        String idk = gson.toJson(boardGameDto);
        fileWriter.write(idk);
        fileWriter.flush();
    }
}
