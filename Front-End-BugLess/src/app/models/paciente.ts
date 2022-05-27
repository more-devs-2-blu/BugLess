import { Localizacao } from './localizacao';

export class Paciente {
  id?: number;
  nome?: string;
  cpf?: string;
  idade?: number;
  sexo?: string;
  endereco: Localizacao = {};

  constructor(obj: Partial<Paciente>) {
    Object.assign(this, obj);
  }
}
