import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Veiculo } from "../model/veiculo.model";

@Injectable()
export class VeiculoService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/v1/veiculos';

  getVeiculos() {
    return this.http.get<Veiculo[]>(this.baseUrl);
  }

  getVeiculoById(id: number) {
    return this.http.get<Veiculo>(this.baseUrl + '/' + id);
  }

  createVeiculo(veiculo: Veiculo) {
    return this.http.post(this.baseUrl, veiculo);
  }

  updateVeiculo(veiculo: Veiculo) {
    return this.http.put(this.baseUrl + '/' + veiculo.id, veiculo);
  }

  deleteVeiculo(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}