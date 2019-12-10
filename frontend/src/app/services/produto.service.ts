
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

const API = environment.API;

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }

  adicionar(obj: any): Observable<any> {
    return this.http.post(`${API}/produto/`, obj);
  }

  alterar(id: number, obj: any): Observable<any> {
    return this.http.put(`${API}/produto/${id}`, obj);
  }

  consultar(): Observable<any> {
    return this.http.get(`${API}/produto`);
  }

  excluir(id: number): Observable<any> {
    return this.http.delete(`${API}/produto/${id}`);
  }

}
