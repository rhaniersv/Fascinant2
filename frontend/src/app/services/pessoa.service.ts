
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

const API = environment.API;

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http: HttpClient) { }

  adicionar(obj: any): Observable<any> {
    return this.http.post(`${API}/pessoa/`, obj);
  }

  alterar(id: number, obj: any): Observable<any> {
    return this.http.put(`${API}/pessoa/${id}`, obj);
  }

  consultar(): Observable<any> {
    return this.http.get(`${API}/pessoa`);
  }

  excluir(id: number): Observable<any> {
    return this.http.delete(`${API}/pessoa/${id}`);
  }

}
