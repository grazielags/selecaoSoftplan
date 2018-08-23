import { Veiculo } from './veiculo.model';

export class ICalculoCusto {
  distanciaPavimentada?: number
  distanciaNaoPavimentada?: number
  veiculo?: Veiculo
  carga?: number
  custoTransporte?: number
}

export class CalculoCusto implements ICalculoCusto {
  constructor(
      public distanciaPavimentada?: number,
      public distanciaNaoPavimentada?: number,
      public veiculo?: Veiculo,
      public carga?: number,
      public custoTransporte?: number
  ) {}
}
