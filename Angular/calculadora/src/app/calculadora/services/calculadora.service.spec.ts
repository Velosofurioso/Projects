import { TestBed, inject } from '@angular/core/testing';

import { CalculadoraService } from './calculadora.service';

describe('CalculadoraService', () => {
  let service: CalculadoraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculadoraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('deve garatir que 1 + 4 = 5',
    inject([CalculadoraService], (service: CalculadoraService) => {
      let soma = service.calcular(1 , 4, CalculadoraService.SOMA); // Esta linha faz a injecao da CalculadoraService para a funcao 
      expect(soma).toEqual(5);
    })
  )

  it('deve garatir que 1 - 4 = -3',
    inject([CalculadoraService], (service: CalculadoraService) => { // Esta linha faz a injecao da CalculadoraService para a funcao 
      let subtracao = service.calcular(1 , 4, CalculadoraService.SUBTRACAO);
      expect(subtracao).toEqual(-3);
    })
  )

  it('deve garatir que 1 / 4 = 0.25',
    inject([CalculadoraService], (service: CalculadoraService) => { // Esta linha faz a injecao da CalculadoraService para a funcao 
      let divisao = service.calcular(1 , 4, CalculadoraService.DIVISAO);
      expect(divisao).toEqual(0.25);
    })
  )

  it('deve garatir que 1 * 4 = 4',
    inject([CalculadoraService], (service: CalculadoraService) => { // Esta linha faz a injecao da CalculadoraService para a funcao 
      let divisao = service.calcular(1 , 4, CalculadoraService.MULTIPLICACAO);
      expect(divisao).toEqual(4);
    })
  )

  it('deve garatir retornar 0 para operação invalida',
    inject([CalculadoraService], (service: CalculadoraService) => { // Esta linha faz a injecao da CalculadoraService para a funcao 
      let divisao = service.calcular(1 , 4, '%');
      expect(divisao).toEqual(0);
    })
  )
});
