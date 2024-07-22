package com.jony.spring_boot.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.spring_boot.request.Books;
import com.jony.spring_boot.response.BooksResponse;
import com.jony.spring_boot.service.BooksService;

@RestController
@RequestMapping("api/books")
public class BooksController {

	@Autowired
	private BooksResponse response;

	@Autowired
	private BooksService service;

	/* save Books */
	@PostMapping("/")
	public ResponseEntity<BooksResponse> save(@RequestBody Books book) {
		Books save = service.save(book);

		if (save != null) {
			response.setError(false);
			response.setMsg("Data Added");
			response.setBook(Arrays.asList(save));

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);

		} else {
			response.setError(true);
			response.setMsg("Failed to Add");

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<BooksResponse> getBook(@PathVariable int id) {
		Books read = service.getById(id);

		if (read != null) {
			response.setError(false);
			response.setMsg("Data Added");
			response.setBook(Arrays.asList(read));

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);

		} else {
			response.setError(true);
			response.setMsg("Failed to Add");

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<BooksResponse> updateBook(@PathVariable int id, @RequestBody Books book) {
		Books update = service.updateById(id, book);

		if (update != null) {
			response.setError(false);
			response.setMsg("Data Updated ");
			response.setBook(Arrays.asList(update));

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);

		} else {
			response.setError(true);
			response.setMsg("Failed to Update");

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BooksResponse> deleteBook(@PathVariable int id) {
		Books delete = service.deleteById(id);

		if (delete != null) {
			response.setError(false);
			response.setMsg("Data Delete Successfully");
			response.setBook(Arrays.asList(delete));

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);

		} else {
			response.setError(true);
			response.setMsg("Failed to Delete");

			return new ResponseEntity<BooksResponse>(response, HttpStatus.OK);
		}

	}
	
	@GetMapping("/export/excel")
    public ResponseEntity<byte[]> exportToExcel() throws IOException {
        List<Books> entities = service.getAllEntities();
       

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ExcelExporter.exportToExcel(entities, out);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=entities.xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok()
                .headers(headers)
                .body(out.toByteArray());
    }

}
