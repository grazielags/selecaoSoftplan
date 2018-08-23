import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CalculoCusto } from "../model/calculo-custo.model";

@Injectable()
export class CalculoCustoService {
  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/v1/calculoCusto';

  calculoCusto(calculoCusto: CalculoCusto) {
    return this.http.post(this.baseUrl, calculoCusto);
  }

}