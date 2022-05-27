export class MarcadorLocalizacao {

  id?:number;
  lat: number = 0;
  lng: number = 0;
  nome?: string;

  constructor(obj: Partial<MarcadorLocalizacao>) {
    Object.assign(this, obj);
  }
}
