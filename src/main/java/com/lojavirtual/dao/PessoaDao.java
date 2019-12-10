package com.lojavirtual.dao;

import org.springframework.data.repository.CrudRepository;

import com.lojavirtual.model.Pessoa;

public interface PessoaDao extends CrudRepository<Pessoa, Integer> {

}
