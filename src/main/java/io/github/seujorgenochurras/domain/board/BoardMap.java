package io.github.seujorgenochurras.domain.board;

import io.github.seujorgenochurras.domain.ImageData;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BoardMap {

    @Id
    private int id;

    @Embedded
    private ImageData imageData;

    public int getId() {
        return id;
    }

    public BoardMap setId(int id) {
        this.id = id;
        return this;
    }

    public ImageData getImageData() {
        return imageData;
    }

    public BoardMap setImageData(ImageData imageData) {
        this.imageData = imageData;
        return this;
    }
}
