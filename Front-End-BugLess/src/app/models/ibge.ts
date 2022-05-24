export class Ibge {
    id?: string;
    nome?: string;
  
    constructor(obj: Partial<Ibge>){
      Object.assign(this, obj);
    }
}
