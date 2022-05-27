export class Bairros {

  bairro?: string;
  total?: number;

  constructor(obj: Partial<Bairros>) {
    Object.assign(this, obj);
  }
}
