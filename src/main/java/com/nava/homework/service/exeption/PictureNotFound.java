package com.nava.homework.service.exeption;


public class PictureNotFound extends Throwable{
    private final Long id;

    public PictureNotFound(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
