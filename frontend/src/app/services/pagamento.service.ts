import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment';

const API = environment.API;

@Injectable({
  providedIn: 'root'
})
export class PagamentoService {
  constructor(private http: HttpClient) { }

  adicionar(obj: any): Observable<any> {
    return this.http.post(`${API}/formapgto/`, obj);
  }

  alterar(id: number, obj: any): Observable<any> {
    return this.http.put(`${API}/formapgto/${id}`, obj);
  }

  consultar(): Observable<any> {
    return this.http.get(`${API}/formapgto`);
  }

  excluir(id: number): Observable<any> {
    return this.http.delete(`${API}/formapgto/${id}`);
  }

}
