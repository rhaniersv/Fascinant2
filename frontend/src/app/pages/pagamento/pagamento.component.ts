import { Component, OnInit } from '@angular/core';
import {PagamentoService} from '../../services/pagamento.service';
import { Pagamento } from 'src/app/model/pagamento.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-payment',
  templateUrl: './pagamento.component.html',
  styleUrls: ['./pagamento.component.css']
})
export class PagamentoComponent implements OnInit {

  lista: Pagamento[] = [];
  obj: Pagamento = {
    descricao: '',
    numMaxParc: 0,
    numPadraoParc: 0,
    intervaloDias: 0,
    percentualAcres: 0
  };

  constructor(private formaPagamentoService: PagamentoService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.formaPagamentoService.consultar().subscribe(r => {
      this.lista = r;
    });
  }

  salvar() {
    this.formaPagamentoService.adicionar(this.obj).subscribe(r => {
      Swal.fire(
        '',
        'Forma de pagamento adicionada com sucesso',
        'success'
      );
      this.listar();
      this.obj = { descricao: '', numMaxParc: 0, numPadraoParc: 0, intervaloDias: 0, percentualAcres: 0 };
    });
  }

  deletar(id: number) {
    this.formaPagamentoService.excluir(id).subscribe(r => {
      Swal.fire(
        '',
        'Forma de pagamento deletada com sucesso',
        'error'
      );
      this.listar();
    });
  }

  carregarDados(pagamento: Pagamento) {
    this.obj = pagamento;
  }
}
