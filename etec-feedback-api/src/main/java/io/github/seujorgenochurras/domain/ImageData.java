package io.github.seujorgenochurras.domain;

import io.github.seujorgenochurras.util.ImageUtil;
import jakarta.persistence.Embeddable;


@Embeddable
public class ImageData {
    private String type;

    private String name;

    private byte[] data;

    public String getType() {
        return type;
    }

    public ImageData setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public ImageData setName(String name) {
        this.name = name;
        return this;
    }

    public byte[] getData() {
        return ImageUtil.decompressImage(data);
    }

    public ImageData setData(byte[] data) {
        this.data = ImageUtil.compressImage(data);
        return this;
    }

}
