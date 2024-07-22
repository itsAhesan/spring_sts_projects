package com.jony.spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/")
	public ResponseEntity<MyResponse> getData(){
		MyResponse response = new MyResponse();
		MyModel model = new MyModel();
		model.setId(101);
		model.setName("Azam");
		MyModel model2 = new MyModel();
		model2.setId(102);
		model2.setName("Azam");
		response.setMessge("success");
		response.setModels(Arrays.asList(model,model2));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
