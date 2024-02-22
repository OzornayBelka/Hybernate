package com.example.hibernate.repository;

import com.example.hibernate.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager entityManager;


    public List<Users> getPersonsByCity(String city) {
        TypedQuery<Users> query = (TypedQuery<Users>) entityManager.createQuery("from Users where city_of_living = :city");
        query.setParameter("city", city).getResultList();
        return (List<Users>) query;
    }
}
