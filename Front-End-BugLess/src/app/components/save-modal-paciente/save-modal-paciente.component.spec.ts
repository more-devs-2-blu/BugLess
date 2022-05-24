import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveModalPacienteComponent } from './save-modal-paciente.component';

describe('SaveModalPacienteComponent', () => {
  let component: SaveModalPacienteComponent;
  let fixture: ComponentFixture<SaveModalPacienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveModalPacienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveModalPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
