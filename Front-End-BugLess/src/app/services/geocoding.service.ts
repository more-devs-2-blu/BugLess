import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GeocodingService {

  // baseUrl: string = `${environment.urlApiBairros}` ;

  constructor(private http: HttpClient) { }

  // getBairros(municipio: string) {
  //   return this.http.get<Ibge[]>(`${this.baseUrl}/${municipio}/distritos`)
  // }





  // // https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY

  // urlAPI : string = 'https://maps.googleapis.com/maps/api/geocode/json?address='
  // key: string = 'AIzaSyDJlpdxVMINcDiag2Nd-h09NeAhzFX7lH8'

  // getAdress(endereco:string){
  //   return this.http.get(`${this.urlAPI}+${endereco}+${this.key}`);
  // }

}
