import { Component, OnInit } from '@angular/core';
import { ViacepService } from 'src/app/services/viacep.service';

@Component({
  selector: 'app-mapa',
  templateUrl: './mapa.component.html',
  styleUrls: ['./mapa.component.scss']
})
export class MapaComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
      
  }

  // google maps zoom level
 zoom: number = 12;

 // initial center position for the map
 lat: number =  -26.879160769716158;
 lng: number = -49.117231781009146;

//  latAntigo: number =  -26.864169;
//  lngMaior: number =  -49.128513;


 clickedMarker(label: string, index: number) {
   console.log(`clicked the marker: ${label || index}`)
 }

 mapClicked($event: any) {
   this.markers.push({
     lat: $event.coords.lat,
     lng: $event.coords.lng,
     draggable: true
   });
 }

 markerDragEnd(m: marker, $event: MouseEvent) {
   console.log('dragEnd', m, $event);
 }

 markers: marker[] = [
   {
     lat: -26.93744665771575,
     lng: -49.05679372466495,
     label: 'A',
     draggable: true
   },
   {
     
     lat: -26.882429277999762,
     lng: -49.078200198078804,
     label: 'B',
     draggable: false
   },
   {
    
     lat: -26.92066948798989,
     lng: -49.099634035290514,
     label: 'C',
     draggable: true
   }
 ]
}

// just an interface for type safety.
interface marker {
 lat: number;
 lng: number;
 label?: string;
 draggable: boolean;
}



