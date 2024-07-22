package com.jony.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jony.spring_boot.request.Books;


@Repository
public interface JpaRepo extends JpaRepository<Books, Integer>{

}
