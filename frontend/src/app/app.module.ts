import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, PreloadAllModules } from '@angular/router';
import { ROUTES } from './app.routing'

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { AdicionarVeiculoComponent } from './veiculo/adicionar-veiculo/adicionar-veiculo.component';
import { EditarVeiculoComponent } from './veiculo/editar-veiculo/editar-veiculo.component';
import { ListarVeiculoComponent } from './veiculo/listar-veiculo/listar-veiculo.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';

import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    AdicionarVeiculoComponent,
    EditarVeiculoComponent,
    ListarVeiculoComponent,
    HomeComponent,
    HeaderComponent
  ],
  imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        HttpModule,
        RouterModule,
        SharedModule.forRoot(),
        RouterModule.forRoot(ROUTES, {preloadingStrategy: PreloadAllModules})
  ],
  providers: [],
  bootstrap: [ AppComponent ],
  exports: [ FormsModule, ReactiveFormsModule ]
})
export class AppModule { }
