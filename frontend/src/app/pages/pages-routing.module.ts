import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LojaComponent} from './loja/loja.component';
import {CarrinhoComponent} from './carrinho/carrinho.component';
import {GrupoprodutoComponent} from './grupoproduto/grupoproduto.component';
import {PagamentoComponent} from './pagamento/pagamento.component';
import {PessoaComponent} from './pessoa/pessoa.component';
import {ProdutoComponent} from './produto/produto.component';


const pagesRoutes: Routes = [
  {path: 'loja', component: LojaComponent},
  {path: 'carrinho', component: CarrinhoComponent},
  {path: 'grupoproduto', component: GrupoprodutoComponent},
  {path: 'pagamento', component: PagamentoComponent},
  {path: 'pessoa', component: PessoaComponent},
  {path: 'produto', component: ProdutoComponent},
];

@NgModule({
  imports: [RouterModule.forChild(pagesRoutes)],
  exports: [RouterModule]
})

export class PagesRoutingModule {
}
