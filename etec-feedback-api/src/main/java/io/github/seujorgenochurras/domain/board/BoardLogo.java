package io.github.seujorgenochurras.domain.board;

import io.github.seujorgenochurras.domain.ImageData;
import jakarta.persistence.*;

@Entity
public class BoardLogo {

    @Id
    private int id;

    @Embedded
    private ImageData imageData;

    public int getId() {
        return id;
    }

    public BoardLogo setId(int id) {
        this.id = id;
        return this;
    }

    public ImageData getImageData() {
        return imageData;
    }

    public BoardLogo setImageData(ImageData imageData) {
        this.imageData = imageData;
        return this;
    }
}
