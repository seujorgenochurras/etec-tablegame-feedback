package io.github.seujorgenochurras.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "feedback")
    private Double feedback;

    @Column(name = "tablegame")
    private String tablegame;
    @Column(name = "voteClass")
    private String voteClass;

    public int id() {
        return id;
    }

    public Vote setId(int id) {
        this.id = id;
        return this;
    }

    public Double feedback() {
        return feedback;
    }

    public Vote setFeedback(double feedback) {
        this.feedback = feedback;
        return this;
    }

    public String tablegame() {
        return tablegame;
    }

    public Vote setTablegame(String tablegame) {
        this.tablegame = tablegame;
        return this;
    }

    public String voteClass() {
        return voteClass;
    }

    public Vote setVoteClass(String voteClass) {
        this.voteClass = voteClass;
        return this;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", feedback=" + feedback +
                ", tablegame='" + tablegame + '\'' +
                ", voteClass='" + voteClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id && Objects.equals(feedback, vote.feedback) && Objects.equals(tablegame, vote.tablegame) && Objects.equals(voteClass, vote.voteClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedback, tablegame, voteClass);
    }
}
