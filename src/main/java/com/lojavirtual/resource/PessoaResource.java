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

import com.lojavirtual.dao.PessoaDao;
import com.lojavirtual.model.Pessoa;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaDao pessoaDao;

	@PostMapping
	public void create(@RequestBody Pessoa pessoa) {
		pessoaDao.save(pessoa);
	}

	@GetMapping(value = "/{id}")
	public Pessoa read(@PathVariable Integer id) {
		Pessoa pessoa;

		pessoa = pessoaDao.findById(id).get();
		return pessoa;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> pessoaBanco = pessoaDao.findById(id);
		BeanUtils.copyProperties(pessoa, pessoaBanco.get(), "id");
		pessoaDao.save(pessoaBanco.get());
		return ResponseEntity.ok(pessoa);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		pessoaDao.deleteById(id);
	}

	@GetMapping
	public List<Pessoa> list() {
		List<Pessoa> list = new ArrayList<>();
		pessoaDao.findAll().forEach(p -> {
			list.add(p);
		});
		return list;
	}

}
