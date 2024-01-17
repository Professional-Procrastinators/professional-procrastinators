package org.launchcode.professionalprocrastinators.models;

import jakarta.persistence.*;

    @Entity
    public class ReviewGallery {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String imageUrl;

        private String description;

        private int rating;

        public ReviewGallery(Long id, String imageUrl, String description, int rating) {
            this.id = id;
            this.imageUrl = imageUrl;
            this.description = description;
            this.rating = rating;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }


