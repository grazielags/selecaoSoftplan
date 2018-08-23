export class IVeiculo {
  id?: number
  modelo?: string
  fatorMultiplicador?: number
}

export class Veiculo implements IVeiculo {
  constructor(
      public id?: number,
      public modelo?: string,
      public fatorMultiplicador?: number
  ) {}
}
