
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

const API = environment.API;

@Injectable({
  providedIn: 'root'
})
export class GrupoProdutoService {

  constructor(private http: HttpClient) { }

  adicionar(obj: any): Observable<any> {
    return this.http.post(`${API}/grupoproduto/`, obj);
  }

  alterar(id: number, obj: any): Observable<any> {
    return this.http.put(`${API}/grupoproduto/${id}`, obj);
  }

  consultar(): Observable<any> {
    return this.http.get(`${API}/grupoproduto`);
  }

  excluir(id: number): Observable<any> {
    return this.http.delete(`${API}/grupoproduto/${id}`);
  }

}
