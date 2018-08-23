import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdicionarVeiculoComponent } from './adicionar-veiculo/adicionar-veiculo.component';
import { EditarVeiculoComponent } from './editar-veiculo/editar-veiculo.component';
import { ListarVeiculoComponent } from './listar-veiculo/listar-veiculo.component';
import { FormGroup, FormControl, FormBuilder, Validators, FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormGroup,
    FormControl,
    FormBuilder,
    Validators,
    FormsModule
  ],
  declarations: [AdicionarVeiculoComponent, EditarVeiculoComponent, ListarVeiculoComponent]
})
export class VeiculoModule { }
