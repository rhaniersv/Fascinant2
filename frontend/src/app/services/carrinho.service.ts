import { Injectable } from '@angular/core';
import {Produto} from '../model/produto.model';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {
  constructor() {}
  listaItens: Produto[] = [];

  getListaItens() {
    return this.listaItens;
  }

  setListaItens(listaItens: Produto[]) {
    this.listaItens = listaItens;
  }
}
