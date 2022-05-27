import { TestBed } from '@angular/core/testing';

import { MarcadorLocalizacaoService } from './marcador-localizacao.service';

describe('MarcadorLocalizacaoService', () => {
  let service: MarcadorLocalizacaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MarcadorLocalizacaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
