import { Component, OnInit } from '@angular/core';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-toast',
  templateUrl: './toast.page.html',
  styleUrls: ['./toast.page.scss'],
})
export class ToastPage implements OnInit {

  constructor(private toastCtrl: ToastController) { }

  ngOnInit() {
  }

  async toastSimples() {
    let toast = await this.toastCtrl.create({
      message: 'Hello World',
      duration: 2000
    });

    toast.present();
  }

  async toastWithOptions() {
    let toast = await this.toastCtrl.create({
      header: 'Toast Header',
      message: 'Click to Close',
      position: 'top',
      buttons: [
        {
          side: 'start',
          icon: 'star',
          text: 'Favorite',
          handler: () => {
            console.log('Favorite');
          }
        },

        {
          text: 'Done',
          role: 'cancel',
          handler: () => {
            console.log('Cancel');
          }
        }
      ]
    });

    toast.present();
  }

}
