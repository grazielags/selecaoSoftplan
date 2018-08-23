import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, FormControl, Validators, NgForm } from '@angular/forms';
import { VeiculoService } from "./../../service/veiculo.service";
import { Veiculo } from "./../../model/veiculo.model";
import {first} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'sel-adicionar-veiculo',
  templateUrl: './adicionar-veiculo.component.html',
  styleUrls: ['./adicionar-veiculo.component.css']
})
export class AdicionarVeiculoComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private veiculoService: VeiculoService) { }

  veiculo: Veiculo;

  ngOnInit() {

    this.veiculo = {
      id: null,
      modelo: null,
      fatorMultiplicador: null
    };

  }

  onSubmit() {
    this.veiculoService.createVeiculo(this.veiculo)
      .subscribe( data => {
        this.router.navigate(['veiculos']);
      });
  }

}