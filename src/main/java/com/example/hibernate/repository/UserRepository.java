package com.example.hibernate.repository;

import com.example.hibernate.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository {
    @Query(value = "select u from Users u where u.cityOfLiving = ?1")
    List<Users> findByCityOfLiving(String city);

    @Query(value = "select u from Users u where u.usersKey.age < ?1 order by u.usersKey.age")
    List<Users> findByAgeLessThanOrderByAge(int age);

    @Query(value = "select u from Users u where u.usersKey.name = ?1 and u.usersKey.surname = ?2")
    Optional<Users> findByNameAndSurname(String name, String surname);
}