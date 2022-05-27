export class Localizacao {
  id?: number;
  cep?: string;
  logradouro?: string;
  numero?: number;
  bairro?: string;
  localidade?: string;
  uf?: string;

  constructor(obj: Partial<Localizacao>) {
    Object.assign(this, obj);
  }
}
