package io.github.seujorgenochurras.dto;

import io.github.seujorgenochurras.domain.board.BoardGame;

public class FeedbackDto {


    private BoardGame boardGame;

    private double averageVotes;

    public BoardGame getBoardGame() {
        return boardGame;
    }

    public FeedbackDto setBoardGame(BoardGame boardGame) {
        this.boardGame = boardGame;
        return this;
    }

    public double getAverageVotes() {
        return averageVotes;
    }

    public FeedbackDto setAverageVotes(double averageVotes) {
        this.averageVotes = averageVotes;
        return this;
    }
}
