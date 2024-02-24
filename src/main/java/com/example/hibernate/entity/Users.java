package com.example.hibernate.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Users {
    @EmbeddedId
    private UsersKey usersKey;
    private String phoneNumber;
    private String cityOfLiving;

    @Override
    public String toString() {
        return "Users{" +
                "usersKey=" + usersKey +
                ", phone_number='" + phoneNumber + '\'' +
                ", city_of_living='" + cityOfLiving + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(usersKey, users.usersKey) && Objects.equals(phoneNumber, users.phoneNumber) && Objects.equals(cityOfLiving, users.cityOfLiving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersKey, phoneNumber, cityOfLiving);
    }
}
