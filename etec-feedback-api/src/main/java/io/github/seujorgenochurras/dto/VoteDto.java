package io.github.seujorgenochurras.dto;

import io.github.seujorgenochurras.domain.board.BoardGame;
import io.github.seujorgenochurras.domain.FeedBack;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;

public class VoteDto {
    @Enumerated(EnumType.ORDINAL)
    private FeedBack feedBack;

    private String voterName = "Annonymous";

    @Valid
    private int boardGameId;

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public VoteDto setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
        return this;
    }

    public String getVoterName() {
        return voterName;
    }

    public VoteDto setVoterName(String voterName) {
        this.voterName = voterName;
        return this;
    }

    public int getBoardGameId() {
        return boardGameId;
    }

    public VoteDto setBoardGameId(int boardGameId) {
        this.boardGameId = boardGameId;
        return this;
    }
}
