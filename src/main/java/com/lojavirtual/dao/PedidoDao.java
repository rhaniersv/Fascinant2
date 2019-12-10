package com.lojavirtual.dao;

import org.springframework.data.repository.CrudRepository;

import com.lojavirtual.model.Pedido;

public interface PedidoDao extends CrudRepository<Pedido, Integer> {

}
