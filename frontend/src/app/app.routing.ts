import { RouterModule, Routes } from '@angular/router';
import { AdicionarVeiculoComponent } from "./veiculo/adicionar-veiculo/adicionar-veiculo.component";
import { EditarVeiculoComponent } from "./veiculo/editar-veiculo/editar-veiculo.component";
import { ListarVeiculoComponent } from "./veiculo/listar-veiculo/listar-veiculo.component";
import { HomeComponent } from "./home/home.component";

export const ROUTES: Routes = [
  { path : '', component : HomeComponent },
  { path: 'veiculos', component: ListarVeiculoComponent },
  { path: 'veiculos/adicionar', component: AdicionarVeiculoComponent },
  { path: 'veiculos/:id', component: EditarVeiculoComponent }
]