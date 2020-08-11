import { Component, OnInit } from '@angular/core';

import { CalculadoraService } from '../services';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {

  // Variaveis auxiliares
  private numero1: string;
  private numero2: string;
  private resultado: number;
  private operacao: string;

  constructor(private calculadoraService: CalculadoraService) { }

  ngOnInit(): void {
    this.limpar(); 
  }

  /**
   *  Inicializa todas as variaveis com valores padrao
   *  @Author Lucas Veloso
   *  @return void
   */
  limpar(): void{
    this.numero1 = '0';
    this.numero2 = '0';
    this.resultado = null;
    this.operacao = null;
  }

  /**
   * Adiciona o numero selecionado para ser calculado posteriomente
   * @param numero : string
   * @return void
   */
  adicionarNumero(numero: string): void {
    if(this.operacao == null) 
      this.numero1 = this.concatenarNumero(this.numero1, numero);
    else
      this.numero2 = this.concatenarNumero(this.numero2, numero);
  }

  /**
   * Retorna o valor selecionado, trata o separador decimal
   * 
   * @param numAtual: string
   * @param numSelecionado: string
   * @return string 
   */
  concatenarNumero(numAtual: string, numSelecionado: string) : string{
    // Caso tenha apenas '0' ou null, reinicia o valor
    if(numAtual === '0' || numAtual === null)
      numAtual = '';

    // Se primeiro digito é '.', concatena '0' antes do ponto
    if(numSelecionado === '.' && numAtual === '')
      return '0.';

    // Caso '.' digitado e ja contenha um '.', apenas retorna
    if(numSelecionado === '.' && numAtual.indexOf('.')> -1)
      return numAtual;

    return numAtual + numSelecionado;
  }

  


  /**
   * Executa a logica quando um operador for selecionado.
   * Caso ja possua uma operacao selecionada executa a operacao anterior,
   * e define a nova operacao 
   * @param operacao: string
   * @return void
   */
  definirOperacao(operacao: string): void{
    // Define uma operacao caso nao exixta uma
    if(this.operacao === null){
      this.operacao = operacao;
      return;
    }

    // Caso operacao definida e numero 2 selecionado realiza o calculo
    if(this.numero2 !== null){
      this.resultado = this.calculadoraService.calcular(parseFloat(this.numero1), 
                                                        parseFloat(this.numero2), operacao);
      this.operacao = operacao;
      this.numero1 = this.resultado.toString();
      this.numero2 = null;
      this.resultado = null;
    }
  }

  /**
   * Efetua o calculo de uma operacao
   * @return void
   */
  calcular(): void{
    if(this.numero2 === null)
      return; 

    this.resultado = this.calculadoraService.calcular(parseFloat(this.numero1), 
                                                      parseFloat(this.numero2), this.operacao);
  }

  /**
   * Retorna o valor a ser exibido na tela da calculadora
   * 
   * @return string
   */
  get display(): string {

    if(this.resultado !==null)
      return this.resultado.toString();

    if(this.numero2 !==null)
      return this.numero2;
    
    return this.numero1;
  }

}
