import { Router } from '@angular/router';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { PacienteService } from './../../services/paciente.service';
import { Localizacao } from './../../models/localizacao';
import { Paciente } from './../../models/paciente';
import { ViacepService } from './../../services/viacep.service';
import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro-paciente',
  templateUrl: './cadastro-paciente.component.html',
  styleUrls: ['./cadastro-paciente.component.scss'],
})
export class CadastroPacienteComponent implements OnInit {

  localizacao = new Localizacao({});
  // Setando sexo vazio para aparecer o Selecione no HTML
  paciente = new Paciente({sexo:''});

  // Objeto reativo para aparecer e sumir os campos de endereco
  showForm = new Subject<boolean>();

  // Variaveis validadoras de campos
  nome = new FormControl('', Validators.minLength(8));
  idade = new FormControl(null, Validators.required);
  cpf = new FormControl(null, Validators.maxLength(11));
  numero = new FormControl(null, Validators.required);
  cep = new FormControl(null, Validators.minLength(8));
  bairro = new FormControl(null, Validators.required);

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
      this.toast.error(error.error.error, 'Cadastro');
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
        console.log(cepModel, this.showForm );
      });
    }
  }

  validaCampos(): boolean{
    return this.nome.valid && this.cpf.valid && this.idade.valid && this.cep.valid && this.bairro.valid && this.numero.valid

  }

}
