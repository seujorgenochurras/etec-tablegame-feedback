package io.github.seujorgenochurras.assemble;

import io.github.seujorgenochurras.domain.board.BoardGame;
import io.github.seujorgenochurras.domain.board.BoardLogo;
import io.github.seujorgenochurras.domain.board.BoardMap;
import io.github.seujorgenochurras.dto.BoardGameDto;
import io.github.seujorgenochurras.service.BoardGameImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardGameAssembler {

    @Autowired
    private BoardGameImageService boardGameImageService;

    public BoardGame toEntity(BoardGameDto boardGameDto){
        BoardGame mappedBoardGame = new BoardGame();

        BoardLogo boardLogo = boardGameImageService.saveLogo(boardGameDto.getLogo());
        BoardMap boardMap = boardGameImageService.saveMap(boardGameDto.getMap());

        mappedBoardGame.setMapImage(boardMap)
                .setLogoImage(boardLogo)
                .setName(boardGameDto.getName());


        return mappedBoardGame;
    }

}
