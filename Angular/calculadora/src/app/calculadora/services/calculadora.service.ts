import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculadoraService {
  // Constantes utilizadas para as operacoes de calculo
  // O readonly informa que esta variavel e uma constante
  static readonly SOMA: string = '+';
  static readonly SUBTRACAO: string = '-';
  static readonly DIVISAO: string = '/';
  static readonly MULTIPLICACAO: string = '*';

  constructor() { }


  // Metodo principal para realizar o calculo dos valores
  calcular(num1: number, num2: number, operacao: string): number{
    let resultado: number;

    switch(operacao){
        case CalculadoraService.SOMA:
          resultado = num1 + num2;
        break

        case CalculadoraService.SUBTRACAO:
          resultado = num1 - num2;
        break

        case CalculadoraService.DIVISAO:
          resultado = num1 / num2;
        break

        case CalculadoraService.MULTIPLICACAO:
          resultado = num1 * num2;
        break

        default:
          resultado = 0;
    }

    return resultado;
  }
}
