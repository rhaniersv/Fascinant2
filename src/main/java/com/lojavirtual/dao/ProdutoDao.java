package com.lojavirtual.dao;

import org.springframework.data.repository.CrudRepository;

import com.lojavirtual.model.Produto;

public interface ProdutoDao extends CrudRepository<Produto, Integer> {

}
