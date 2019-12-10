import {Pessoa} from './pessoa.model';
import {Pagamento} from './pagamento.model';
import {Pedido} from './pedido.model';

export class ItensPedido {
  cliente: Pessoa;
  pedido: Pedido;
  formaPgto: Pagamento;
  qtde: number;
  valorUnit: number;
  subTotal: number;
}
