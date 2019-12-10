package com.lojavirtual.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.dao.FormaPgtoDao;
import com.lojavirtual.model.FormaPgto;

@RestController
@RequestMapping(value = "/formapgto")
public class FormaPgtoResource {

	@Autowired
	private FormaPgtoDao formaPgtoDao;

	@PostMapping
	public void create(@RequestBody FormaPgto formaPgto) {
		formaPgtoDao.save(formaPgto);
	}

	@GetMapping(value = "/{id}")
	public FormaPgto read(@PathVariable Integer id) {
		FormaPgto formaPgto;

		formaPgto = formaPgtoDao.findById(id).get();
		return formaPgto;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<FormaPgto> update(@PathVariable Integer id, @RequestBody FormaPgto formaPgto) {
		Optional<FormaPgto> formaPgtoBanco = formaPgtoDao.findById(id);
		BeanUtils.copyProperties(formaPgto, formaPgtoBanco.get(), "id");
		formaPgtoDao.save(formaPgtoBanco.get());
		return ResponseEntity.ok(formaPgto);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		formaPgtoDao.deleteById(id);
	}

	@GetMapping
	public List<FormaPgto> list() {
		List<FormaPgto> list = new ArrayList<>();
		formaPgtoDao.findAll().forEach(p -> {
			list.add(p);
		});
		return list;
	}

}
