import { MarcadorLocalizacao } from './../models/marcador-localizacao';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MarcadorLocalizacaoService {

  constructor(private http: HttpClient) { }

  listAll() {
    return this.http.get<MarcadorLocalizacao[]>(`http://localhost:8080/api/marcador`);
  }

}
