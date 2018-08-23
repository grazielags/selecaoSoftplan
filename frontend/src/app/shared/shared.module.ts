import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { VeiculoService } from "./../service/veiculo.service";
import { CalculoCustoService } from "./../service/calculo-custo.service";

@NgModule({
  declarations: [],
  imports: [ CommonModule, FormsModule, ReactiveFormsModule ],
  exports: [ CommonModule, FormsModule, ReactiveFormsModule ]
})
export class SharedModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SharedModule,
      providers:[ VeiculoService, CalculoCustoService ]
    }
  }
}
