import { Bairros } from './../models/bairros';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalizacaoService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Bairros[]>(`${environment.urlAPIBack}/localizacao/bairros`);
  }

}
