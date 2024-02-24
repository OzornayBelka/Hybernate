package com.example.hibernate.repository;

import com.example.hibernate.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository {

    List<Users> findByCityOfLiving (String city);

    List<Users> findByAgeLessThanOrderByAge(int age);

    Optional<Users> findByNameAndSurname(String name, String surname);
}