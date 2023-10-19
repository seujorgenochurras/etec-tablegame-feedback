package io.github.seujorgenochurras.domain;

import io.github.seujorgenochurras.domain.board.BoardGame;
import jakarta.persistence.*;

@Entity
public class Vote {

    @Id
    private int id;

    private String voterName = "Annonymous";

    @ManyToOne
    private BoardGame boardGame;

    @Enumerated(EnumType.ORDINAL)
    private FeedBack feedback;

    public int getId() {
        return id;
    }

    public Vote setId(int id) {
        this.id = id;
        return this;
    }

    public String getVoterName() {
        return voterName;
    }

    public Vote setVoterName(String voterName) {
        this.voterName = voterName;
        return this;
    }

    public BoardGame getBoardGame() {
        return boardGame;
    }

    public Vote setBoardGame(BoardGame boardGame) {
        this.boardGame = boardGame;
        return this;
    }

    public FeedBack getFeedback() {
        return feedback;
    }

    public Vote setFeedback(FeedBack feedback) {
        this.feedback = feedback;
        return this;
    }
}

