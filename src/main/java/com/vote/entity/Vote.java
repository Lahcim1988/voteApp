package com.vote.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Vote {


    private VoteId pk;          // primary key - id
    private Boolean upvote;

    public Boolean getUpvote() {
        return upvote;
    }

    public void setUpvote(Boolean upvote) {
        this.upvote = upvote;
    }

    @EmbeddedId                  // contains foreign ID
    public VoteId getPk() {
        return pk;
    }

    public void setPk(VoteId pk) {
        this.pk = pk;
    }
}
