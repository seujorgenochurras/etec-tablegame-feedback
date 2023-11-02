package io.github.seujorgenochurras.service;

import io.github.seujorgenochurras.domain.ImageData;
import io.github.seujorgenochurras.domain.board.BoardGame;
import io.github.seujorgenochurras.domain.board.BoardLogo;
import io.github.seujorgenochurras.domain.board.BoardMap;
import io.github.seujorgenochurras.repository.BoardLogoRepository;
import io.github.seujorgenochurras.repository.BoardMapRepository;
import io.github.seujorgenochurras.util.ImageUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BoardGameImageService {
    @Autowired
    private BoardLogoRepository boardLogoRepository;

    @Autowired
    private BoardMapRepository boardMapRepository;

    @Transactional
    public BoardLogo saveLogo(MultipartFile boardLogoFile) {
        byte[] imageBytes = new byte[0];
        try {
            imageBytes = boardLogoFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BoardLogo boardLogo = new BoardLogo()
                .setImageData(new ImageData()
                        .setData(imageBytes)
                        .setName(boardLogoFile.getOriginalFilename())
                        .setType(boardLogoFile.getContentType()));

        return boardLogoRepository.save(boardLogo);
    }

    @Transactional
    public BoardMap saveMap(MultipartFile boardMapFile) {
        byte[] imageBytes = new byte[0];
        try {
            imageBytes = boardMapFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BoardMap boardMap = new BoardMap()
                .setImageData(new ImageData()
                        .setData(imageBytes)
                        .setName(boardMapFile.getOriginalFilename())
                        .setType(boardMapFile.getContentType()));

        return boardMapRepository.save(boardMap);
    }
}
