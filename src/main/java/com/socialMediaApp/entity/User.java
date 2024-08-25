package com.socialMediaApp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    @Size(min = 2, message = "Name should be at least 2 character ")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Birth date should be in past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
