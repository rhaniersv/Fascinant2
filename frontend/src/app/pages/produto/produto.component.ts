import { Component, OnInit } from '@angular/core';
import {Produto} from '../../model/produto.model';
import {GrupoProduto} from '../../model/grupoproduto.model';
import {ProdutoService} from '../../services/produto.service';
import {GrupoProdutoService} from '../../services/grupoproduto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  lista: Produto[] = []
  listaGrupos: GrupoProduto[] = []
  obj: Produto = {
    nome: '',
    preco: 0,
    descricao: '',
    qtdeEstoque: 0,
    und: '',
    grupo: new GrupoProduto
  }
  grupoId = 0;

  constructor(
    private produtoService: ProdutoService,
    private grupoProdutoService: GrupoProdutoService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.produtoService.consultar().subscribe(r => {
      this.lista = r;
    });
    this.grupoProdutoService.consultar().subscribe(r => {
      this.listaGrupos = r;
    })
  }

  salvar() {
    this.listaGrupos.forEach(grupo => {
      if (grupo.id === this.grupoId) {
        this.obj.grupo.id = grupo.id;
        this.obj.grupo.nome = grupo.nome;
      }
    });
    this.produtoService.adicionar(this.obj).subscribe(r => {
      this.listar();
      this.obj = { nome: '', preco: 0, descricao: '', qtdeEstoque: 0, und: '', grupo: new GrupoProduto };
    });
    Swal.fire(
      '',
      'Produto adicionado com sucesso',
      'success'
    );
  }

  deletar(id: number) {
    this.produtoService.excluir(id).subscribe(r => {
      Swal.fire(
        '',
        'Produto deletado com sucesso',
        'error'
      );
      this.listar();
    });
  }

  carregarDados(produto: Produto) {
    this.obj = produto;
  }

}
