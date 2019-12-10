import { Component, OnInit } from '@angular/core';
import {ProdutoService} from '../../services/produto.service';
import {GrupoProdutoService} from '../../services/grupoproduto.service';
import {PessoaService} from '../../services/pessoa.service';
import {CarrinhoService} from '../../services/carrinho.service';
import {Produto} from '../../model/produto.model';
import {GrupoProduto} from '../../model/grupoproduto.model';
import {Pessoa} from '../../model/pessoa.model';

@Component({
  selector: 'app-cart',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {
  listadecompras: Produto[];
  index = 0;
  grupos: GrupoProduto[];
  produtos: Produto[];
  pessoas: Pessoa[];

  constructor(
    private produtoServ: ProdutoService,
    private GrupoServ: GrupoProdutoService,
    private PessoaServ: PessoaService,
    private CarrinhoServ: CarrinhoService
  ) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.produtoServ.consultar().subscribe(p => { this.produtos = p; });
    this.GrupoServ.consultar().subscribe(p => { this.grupos = p; });
    this.PessoaServ.consultar().subscribe(p => { this.pessoas = p; });
    this.setListaCompras();
  }

  setListaCompras() {
    this.listadecompras = this.CarrinhoServ.getListaItens();
  }

  deletar(obj: any) {
    for (let index = 0; index < this.listadecompras.length; index++) {
      const element = this.listadecompras[index];
      if (obj === element) {
        this.index = index;
      }
    }
    this.listadecompras = this.listadecompras.splice(this.listadecompras.length, this.index - 1);
    this.CarrinhoServ.setListaItens(this.listadecompras);
    this.listar();
  }

}
