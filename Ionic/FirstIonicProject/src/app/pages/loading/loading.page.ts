import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.page.html',
  styleUrls: ['./loading.page.scss'],
})
export class LoadingPage implements OnInit {

  constructor(private loadingCtrl : LoadingController) { }

  ngOnInit() {
  }

  async abrirLoading() {
    const loading = await this.loadingCtrl.create({
      message: 'Processando....',
      duration: 2000
    });
    await loading.present();
  }

  async abrirLoadingRequisicao() {
    const loading = await this.loadingCtrl.create({
      spinner: 'lines',
      message: 'Processando....',
    });

    setTimeout(() => {
      console.log('Resposta da Requisição');
      loading.dismiss();
    }, 2000);
    await loading.present();
  }

}
