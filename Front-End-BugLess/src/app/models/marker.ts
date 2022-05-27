export class Marker {
  lat: number = 0;
  lng: number = 0;
  label?: string;
  draggable?: boolean;

  constructor(obj: Partial<Marker>) {
    Object.assign(this, obj);
  }
}
