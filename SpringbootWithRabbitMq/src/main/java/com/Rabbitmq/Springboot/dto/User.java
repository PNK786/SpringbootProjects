package com.Rabbitmq.Springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class User
{
    @JsonProperty("id")
    private int id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
