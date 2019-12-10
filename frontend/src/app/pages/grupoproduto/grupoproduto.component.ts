import { Component, OnInit } from '@angular/core';
import {GrupoProdutoService} from '../../services/grupoproduto.service';
import {GrupoProduto} from '../../model/grupoproduto.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-grupoproduto',
  templateUrl: './grupoproduto.component.html',
  styleUrls: ['./grupoproduto.component.css']
})
export class GrupoprodutoComponent implements OnInit {

  constructor(private grupoprodutoService: GrupoProdutoService) { }

  lista: GrupoProduto[] = [];
  obj: GrupoProduto = {
    id: 0,
    nome: ''
  };

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.grupoprodutoService.consultar().subscribe(r => {
      this.lista = r;
    });
  }

  salvar() {
    this.grupoprodutoService.adicionar(this.obj).subscribe(r => {
      Swal.fire(
        '',
        'Grupo adicionado com sucesso',
        'success'
      );
      this.listar();
      this.obj = {
        id: 0,
        nome: ''
      };
    });
  }

  deletar(id: number) {
    this.grupoprodutoService.excluir(id).subscribe(p => {
      this.listar();
      Swal.fire(
        '',
        'Grupo deletado com sucesso',
        'error'
      );
    });
  }

  carregarDados(grupo: GrupoProduto) {
    this.obj = grupo;
  }

}
