import { Localizacao } from './../models/localizacao';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ViacepService {

  constructor(private http: HttpClient) { }

  getCep(cep: string){
    const urlGet = `${environment.urlApiViaCep}${cep}/json`;
    return this.http.get<Localizacao>(urlGet);
  }



}
