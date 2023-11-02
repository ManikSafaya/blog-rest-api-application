package com.manik.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manik.apis.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
