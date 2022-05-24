import { Router } from '@angular/router';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { PacienteService } from './../../services/paciente.service';
import { Localizacao } from './../../models/localizacao';
import { Paciente } from './../../models/paciente';
import { ViacepService } from './../../services/viacep.service';
import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.scss'],
})
export class CadastroPacienteComponent implements OnInit {
  localizacao = new Localizacao({});
  paciente = new Paciente({});

  showForm = new Subject<boolean>();

  cadastroAction = new Paciente({});

  constructor(
    private viaCepService: ViacepService,
    private service: PacienteService,
    private toast: ToastrService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  create() {
    this.paciente.endereco = this.localizacao;
    this.service.create(this.paciente).subscribe((response) => {
      this.router.navigate(['home'])
        this.toast.success('Paciente cadastrado com sucesso!', 'Cadastro');
    }, error => {
      this.toast.error('Paciente não cadastrado ocorreu um erro!', 'Cadastro');
    });
  }

  getViaCEP(cep: FocusEvent) {
    if ((cep.target as HTMLInputElement)?.value) {
      let inputCEP = (cep.target as HTMLInputElement)?.value;
      console.log(inputCEP);
      const cepResponse = this.viaCepService.getCep(inputCEP);
      cepResponse.subscribe((cepModel) => {
        this.localizacao = cepModel;
        this.showForm.next(true);
      });
    }
  }

}
