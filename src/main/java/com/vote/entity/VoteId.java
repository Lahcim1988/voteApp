package com.vote.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import java.io.Serializable;


// Many to Many - adding additional column to relationship table - have to create new entity
@Embeddable
public class VoteId implements Serializable {


    private User user;
    private Feature feature;

        @ManyToOne
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @ManyToOne
        public Feature getFeature() {
            return feature;
        }

        public void setFeature(Feature feature) {
            this.feature = feature;
        }
    }
