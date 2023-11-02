package io.github.seujorgenochurras.domain;

import jakarta.persistence.Enumerated;


public enum FeedBack {
    HAPPY(5),
    SATISFACTION(4),

    ACCEPTABLE(3),

    BAD(2),

    HATEFUL(1);

    private final int feedback;
    private int getFeedback(){
        return this.feedback;
    }

    FeedBack(int feedback) {
        this.feedback = feedback;
    }
}
