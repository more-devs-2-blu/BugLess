import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AgmCoreModule } from '@agm/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { MapaComponent } from './components/mapa/mapa.component';
import { CadastroPacienteComponent } from './components/cadastro-paciente/cadastro-paciente.component';
import { SaveModalPacienteComponent } from './components/save-modal-paciente/save-modal-paciente.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    MapaComponent,
    CadastroPacienteComponent,
    SaveModalPacienteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDJlpdxVMINcDiag2Nd-h09NeAhzFX7lH8'
    }),
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-top-right',
      timeOut: 4000,
      countDuplicates: true,
      progressBar: true,
      extendedTimeOut: 1000
    }
      )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
