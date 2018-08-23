import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { VeiculoService } from "./../../service/veiculo.service";
import { Veiculo } from "./../../model/veiculo.model";

@Component({
  selector: 'sel-listar-veiculo',
  templateUrl: './listar-veiculo.component.html',
  styleUrls: ['./listar-veiculo.component.css']
})
export class ListarVeiculoComponent implements OnInit {

  veiculos: Veiculo[];

  constructor(private router: Router, private veiculoService: VeiculoService) { }

  ngOnInit() {
    this.veiculoService.getVeiculos()
      .subscribe( data => {
        this.veiculos = data;
      });
  }

  adicionarVeiculo(): void {
    this.router.navigate(['veiculos/adicionar']);
  };

  editarVeiculo(veiculo: Veiculo): void {
    localStorage.removeItem("veiculoId");
    localStorage.setItem("veiculoId", veiculo.id.toString());
    this.router.navigate(['veiculos/' + veiculo.id.toString()]);
  };

  deletarVeiculo(veiculo: Veiculo): void {
    this.veiculoService.deleteVeiculo(veiculo.id)
      .subscribe( data => {
        this.veiculos = this.veiculos.filter(u => u !== veiculo);
      })
  };
}