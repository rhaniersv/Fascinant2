import {Pagamento} from './pagamento.model';
import {Pessoa} from './pessoa.model';

export class Pedido {
  cliente: Pessoa;
  dataEmissao: Pagamento;
  dataAutorizacao: Date;
  status: string;
  total: number;
  desconto: number;
}
