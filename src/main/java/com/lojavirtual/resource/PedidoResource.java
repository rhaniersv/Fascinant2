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

import com.lojavirtual.dao.PedidoDao;
import com.lojavirtual.model.Pedido;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {

	@Autowired
	private PedidoDao pedidoDao;

	@PostMapping
	public void create(@RequestBody Pedido obj) {
		pedidoDao.save(obj);
	}

	@GetMapping(value = "/{id}")
	public Pedido read(@PathVariable Integer id) {
		Pedido obj;

		obj = pedidoDao.findById(id).get();
		return obj;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody Pedido obj) {
		Optional<Pedido> objBanco = pedidoDao.findById(id);
		BeanUtils.copyProperties(obj, objBanco.get(), "id");
		pedidoDao.save(objBanco.get());
		return ResponseEntity.ok(obj);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		pedidoDao.deleteById(id);
	}

	@GetMapping
	public List<Pedido> list() {
		List<Pedido> list = new ArrayList<>();
		pedidoDao.findAll().forEach(p -> {
			list.add(p);
		});
		return list;
	}

}
