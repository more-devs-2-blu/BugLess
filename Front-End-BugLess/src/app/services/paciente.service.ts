import { environment } from './../../environments/environment';
import { Paciente } from './../models/paciente';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PacienteService {
  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<Paciente[]>(`${environment.urlAPIBack}/paciente`);
  }

  create(paciente: Paciente) {
    return this.http.post<Paciente>(`${environment.urlAPIBack}/paciente`, paciente);
  }
}
