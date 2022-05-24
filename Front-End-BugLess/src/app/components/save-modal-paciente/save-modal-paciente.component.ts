import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Paciente } from 'src/app/models/paciente';
import { PacienteService } from 'src/app/services/paciente.service';

@Component({
  selector: 'app-save-modal-paciente',
  templateUrl: './save-modal-paciente.component.html',
  styleUrls: ['./save-modal-paciente.component.scss']
})
export class SaveModalPacienteComponent implements OnInit {

  @Input()
  cadastroSave = new Paciente({});

  constructor(private service: PacienteService,
              private router: Router) { }

  ngOnInit(): void {
  }

  confirm() {
    setTimeout(() => {
      this.router.navigate(['/','home']);
    }, 0)
  }
}
