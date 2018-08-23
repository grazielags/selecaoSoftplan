import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, NgForm } from '@angular/forms';
import { Router } from "@angular/router";
import { CalculoCusto } from "./../model/calculo-custo.model"
import { CalculoCustoService } from "./../service/calculo-custo.service";
import { VeiculoService } from "./../service/veiculo.service";
import { Veiculo } from "./../model/veiculo.model"

@Component({
  selector: 'sel-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private calculoCustoService: CalculoCustoService,
    private veiculoService: VeiculoService
  ) { }

  calculoCusto: CalculoCusto;
  veiculos: Veiculo[];

  ngOnInit() {

    this.calculoCusto = {
      distanciaPavimentada: null,
      distanciaNaoPavimentada: null,
      veiculo: null,
      carga: null,
      custoTransporte: null
    };

    this.veiculoService.getVeiculos()
      .subscribe( data => {
        this.veiculos = data;
      }
    );

  }

  calcularCusto() {
    this.calculoCustoService.calculoCusto(this.calculoCusto)
      .subscribe( data => {
        this.calculoCusto = data;
        console.log(this.calculoCusto.veiculo);
      })
    ;
  }

}
