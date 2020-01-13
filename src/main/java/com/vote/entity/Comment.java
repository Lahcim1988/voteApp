package com.vote.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Comment {

    private ComentId pk;
    private String text;

    @EmbeddedId
    public ComentId getPk() {
        return pk;
    }

    public void setPk(ComentId pk) {
        this.pk = pk;
    }

    @Column(length = 5000)                  // update column normal is 255 characters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
