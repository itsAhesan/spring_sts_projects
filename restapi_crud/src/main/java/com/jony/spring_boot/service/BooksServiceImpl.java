package com.jony.spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jony.spring_boot.repository.JpaRepo;
import com.jony.spring_boot.request.Books;

@Component
public class BooksServiceImpl implements BooksService{
	
	@Autowired
	private JpaRepo repo;

	@Override
	public Books save(Books book) {
		
		return repo.save(book);
	}

	@Override
	public Books getById(int id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public Books updateById(int id,Books book) {
		Books findById = repo.findById(id).orElse(null);
		findById.setName(book.getName());
		findById.setPrice(book.getPrice());
		Books save = repo.save(findById);
		
		return save;
	}

	@Override
	public Books deleteById(int id) {
		Books findById = repo.findById(id).orElse(null);
		
		if(findById!=null) {
			repo.delete(findById);
			return findById;
		}else {
			return null;
		}
		
		
		
	}

	@Override
	public List<Books> getAllEntities() {
		
		return repo.findAll();
	}

}
