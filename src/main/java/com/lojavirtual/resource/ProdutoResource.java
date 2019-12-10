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

import com.lojavirtual.dao.ProdutoDao;
import com.lojavirtual.model.Produto;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoDao produtoDao;

	@PostMapping
	public void create(@RequestBody Produto obj) {
		produtoDao.save(obj);
	}

	@GetMapping(value = "/{id}")
	public Produto read(@PathVariable Integer id) {
		Produto obj;

		obj = produtoDao.findById(id).get();
		return obj;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto obj) {
		Optional<Produto> objBanco = produtoDao.findById(id);
		BeanUtils.copyProperties(obj, objBanco.get(), "id");
		produtoDao.save(objBanco.get());
		return ResponseEntity.ok(obj);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		produtoDao.deleteById(id);
	}

	@GetMapping
	public List<Produto> list() {
		List<Produto> list = new ArrayList<>();
		produtoDao.findAll().forEach(p -> {
			list.add(p);
		});
		return list;
	}

}
