package io.github.seujorgenochurras.domain.board;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
public class BoardGame {

    @Id
    private int id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "logoImageFK")
    private BoardLogo logoImage;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "mapImageFK")
    private BoardMap mapImage;

    private String name;

    public BoardLogo getLogoImage() {
        return logoImage;
    }

    public BoardGame setLogoImage(BoardLogo logoImage) {
        this.logoImage = logoImage;
        return this;
    }

    public BoardMap getMapImage() {
        return mapImage;
    }

    public BoardGame setMapImage(BoardMap mapImage) {
        this.mapImage = mapImage;
        return this;
    }

    public int getId() {
        return id;
    }

    public BoardGame setId(int id) {
        this.id = id;
        return this;
    }


    public String getName() {
        return name;
    }

    public BoardGame setName(String name) {
        this.name = name;
        return this;
    }
}
