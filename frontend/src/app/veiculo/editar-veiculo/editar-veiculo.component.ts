import { Component, OnInit } from '@angular/core';
import { VeiculoService } from "./../../service/veiculo.service";
import {Router} from "@angular/router";
import { Veiculo } from "./../../model/veiculo.model";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { first } from "rxjs/operators";

@Component({
  selector: 'sel-editar-veiculo',
  templateUrl: './editar-veiculo.component.html',
  styleUrls: ['./editar-veiculo.component.css']
})
export class EditarVeiculoComponent implements OnInit {

  veiculo: Veiculo;
  constructor(private formBuilder: FormBuilder, private router: Router, private veiculoService: VeiculoService) { }

  ngOnInit() {
    let veiculoId = localStorage.getItem("veiculoId");
    if(!veiculoId) {
      alert("Ação inválida.")
      this.router.navigate(['veiculo']);
      return;
    }

    this.veiculo = {
      id: null,
      modelo: null,
      fatorMultiplicador: null
    };

    this.veiculoService.getVeiculoById(+veiculoId)
      .subscribe( data => {
        this.veiculo = data;
      });
  }

  editarVeiculo() {
    this.veiculoService.updateVeiculo(this.veiculo)
      .subscribe( data => {
        this.router.navigate(['veiculos']);
      });
  }
}