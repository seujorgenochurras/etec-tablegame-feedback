package io.github.seujorgenochurras.dto;


import org.springframework.web.multipart.MultipartFile;


public class BoardGameDto {

    private MultipartFile logo;
    private MultipartFile map;
    private String name;

    public MultipartFile getLogo() {
        return logo;
    }

    public BoardGameDto setLogo(MultipartFile logo) {
        this.logo = logo;
        return this;
    }

    public MultipartFile getMap() {
        return map;
    }

    public BoardGameDto setMap(MultipartFile map) {
        this.map = map;
        return this;
    }

    public String getName() {
        return name;
    }

    public BoardGameDto setName(String name) {
        this.name = name;
        return this;
    }

}
