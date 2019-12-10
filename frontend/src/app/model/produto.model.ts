import {GrupoProduto} from './grupoproduto.model';

export class Produto {
  nome: string;
  preco: number;
  descricao: string;
  qtdeEstoque: number;
  und: string;
  grupo: GrupoProduto;
}
