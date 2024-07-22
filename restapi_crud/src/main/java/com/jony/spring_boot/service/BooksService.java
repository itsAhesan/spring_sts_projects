package com.jony.spring_boot.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.jony.spring_boot.request.Books;

@Service
public interface BooksService {

	Books save(Books book);

	Books getById(int id);

	Books updateById(int id,Books book);

	Books deleteById(int id);

	List<Books> getAllEntities();

}
