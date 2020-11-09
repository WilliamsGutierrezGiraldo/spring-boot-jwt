package com.mainsoft.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainsoft.test.dto.ProductoDto;
import com.mainsoft.test.service.ProductoService;
import com.mainsoft.test.util.Response;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@PostMapping(path = "/save")
	public ResponseEntity<Response> save(@RequestBody ProductoDto dto) {
		Response response = service.save(dto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<Response> update(@RequestBody ProductoDto dto) {
		Response response = service.update(dto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Response> delete(@PathVariable(value = "id") Long id) {
		Response response = service.deleteById(id);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/findOne/{id}")
	public ResponseEntity<Response> fetchById(@PathVariable(value = "id") Long id) {
		Response response = service.fetchById(id);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/findAll")
	public ResponseEntity<Response> fetchAll() {
		Response response = service.fetchAll();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
