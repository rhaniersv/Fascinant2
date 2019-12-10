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

import com.lojavirtual.dao.ItensPedidoDao;
import com.lojavirtual.model.ItensPedido;

@RestController
@RequestMapping("/itenspedido")
public class ItensPedidoResource {

	@Autowired
	private ItensPedidoDao itensPedidoDao;

	@PostMapping
	public void create(@RequestBody ItensPedido formaPgto) {
		itensPedidoDao.save(formaPgto);
	}

	@GetMapping(value = "/{id}")
	public ItensPedido read(@PathVariable Integer id) {
		ItensPedido formaPgto;

		formaPgto = itensPedidoDao.findById(id).get();
		return formaPgto;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ItensPedido> update(@PathVariable Integer id, @RequestBody ItensPedido formaPgto) {
		Optional<ItensPedido> formaPgtoBanco = itensPedidoDao.findById(id);
		BeanUtils.copyProperties(formaPgto, formaPgtoBanco.get(), "id");
		itensPedidoDao.save(formaPgtoBanco.get());
		return ResponseEntity.ok(formaPgto);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		itensPedidoDao.deleteById(id);
	}

	@GetMapping
	public List<ItensPedido> list() {
		List<ItensPedido> list = new ArrayList<>();
		itensPedidoDao.findAll().forEach(p -> {
			list.add(p);
		});
		return list;
	}
}