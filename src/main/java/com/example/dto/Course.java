package com.example.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("courses")
public class Course {

    private String name;
    private String lastname;
    private Double score;

    public Course(String name, String lastname, Double score) {
        this.name = name;
        this.lastname = lastname;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public static class Builder{
        private String name;
        private String lastname;
        private Double score;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }

        public Builder withScore(Double score){
            this.score = score;
            return this;
        }

        public Course build(){
            return new Course(name, lastname, score);
        }

    }
}
