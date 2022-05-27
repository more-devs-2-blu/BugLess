import { MarcadorLocalizacaoService } from './../../services/marcador-localizacao.service';
import { MarcadorLocalizacao } from './../../models/marcador-localizacao';
import { Marker } from './../../models/marker';
import { Bairros } from './../../models/bairros';
import { Observable } from 'rxjs';
import { LocalizacaoService } from './../../services/localizacao.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mapa',
  templateUrl: './mapa.component.html',
  styleUrls: ['./mapa.component.scss'],
})
export class MapaComponent implements OnInit {
  // Observable
  bairros$ = new Observable<Bairros[]>();
  marcadores$ = new Observable<MarcadorLocalizacao[]>();

  totalBairro: Bairros[] = new Array();
  markers: Marker[] = new Array();

  // Top 3 bairros com mais casos
  bairroComMaisCaso = new Bairros({});
  segundoBairroComMaisCaso = new Bairros({});
  terceiroBairroComMaisCaso = new Bairros({});

  constructor(
    private localizacaoService: LocalizacaoService,
    private marcadorService: MarcadorLocalizacaoService
  ) {}

  ngOnInit(): void {
    this.listAllBairros();
  }

  // lista todos os bairros e casos cadastrados
  async listAllBairros() {
    this.bairros$ = this.localizacaoService.getAll();

    await this.getBairroFromObservable();
  }

  // pega as coordenadas dos bairros
  async listAllLocalizacao() {
    this.marcadores$ = this.marcadorService.listAll();

    // this.marcadores$.subscribe(
    //   (lista) =>
    //   console.log(lista )
    // )

    await this.getListFromObservable();
  }

  // Pega as informações do objeto observable e insere no objeto array de bairro
  async getBairroFromObservable() {
    await this.bairros$.forEach((bairro) => {
      bairro.forEach((element) => {
        this.totalBairro.push(element);
        this.totalBairro.sort(
          (a: Bairros, b: Bairros) => (a.total || 0) - (b.total || 0)
        );
      });
    });
    // Chama o método para pegar os bairros com mais casos
    this.bairrosComMaisCasos(this.totalBairro);
    console.log(
      this.bairroComMaisCaso.bairro,
      this.segundoBairroComMaisCaso.bairro,
      this.terceiroBairroComMaisCaso.bairro
    );
    // Aguarda a requisição acima finalizar para que seja chamado o outro método de consulta ao banco, pois é preciso informação
    // do método acima para o processamento desse método
    setTimeout(() => {
      this.listAllLocalizacao();
    }, 50);
  }

  // Percorre o array que retornará da requisição ao back, e insere os bairros com maiores casos no array para que seja mostrado no mapa
  async getListFromObservable() {
    await this.marcadores$.forEach((marcadores) => {
      marcadores.forEach((element) => {
        if (element.nome === this.bairroComMaisCaso.bairro) {
          this.markers.push(element);
        } else if (element.nome === this.segundoBairroComMaisCaso.bairro) {
          this.markers.push(element);
        } else if (element.nome === this.terceiroBairroComMaisCaso.bairro) {
          this.markers.push(element);
        }
      });
    });
  }

// Pega os últimos 3 bairros do array, pois o array foi ordenado e os últimos são os com mais casos registrados
  bairrosComMaisCasos(bairros: Bairros[]) {
    this.bairroComMaisCaso = bairros.pop() || new Bairros({});
    this.segundoBairroComMaisCaso = bairros.pop() || new Bairros({});
    this.terceiroBairroComMaisCaso = bairros.pop() || new Bairros({});
  }

  // google maps zoom level
  zoom: number = 11;

  // initial center position for the map = Blumenau
  lat: number = -26.829996032610232;
  lng: number = -49.09085017522761;

}
