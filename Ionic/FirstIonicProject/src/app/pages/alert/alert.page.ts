import { Component, OnInit } from '@angular/core';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.page.html',
  styleUrls: ['./alert.page.scss'],
})
export class AlertPage implements OnInit {

  constructor(private alertCtrl: AlertController) { }

  ngOnInit() {
  }

  async alert() {
    const alert = await this.alertCtrl.create({
      header: 'Alert',
      subHeader: 'Subtitle',
      message: 'This is a Alert message.',
      buttons: ['OK']
    });
    
    alert.present();
  }

  async multipleButtons() {
    const alert = await this.alertCtrl.create({
      header: 'Multiple Alert',
      message: 'This is a Alert message.',
      buttons: ['Cancel', 'Open Modal', 'OK']
    });
    
    alert.present();
  }

  async confirm() {
    const alert = await this.alertCtrl.create({
      header: 'Confirm Alert',
      message: 'This is a Alert <strong>message</strong>.',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary',
          handler: (res) => {
            console.log('Confirm Cancel');
          }
        }, 
        {
          text: 'OK',
          handler: () => {
            console.log('Confirm Okay');
          }
        }]
    });
    
    alert.present();
  }

  async prompt() {
    const alert = await this.alertCtrl.create({
      header: 'Prompt',
      inputs: [
        {
          name: 'email',
          type: 'text',
          placeholder: 'Informe seu email'
        },
        {
          name: 'senha',
          type: 'password',
          id: 'name2-id',
          placeholder: 'Informe sua senha'
        },
        //multiline input
        {
          name: 'paragraph',
          id: 'paragraph',
          type: 'textarea',
          placeholder: 'Placeholder 3'
        },
        {
          name: 'name3',
          value: 'http://ionicframework.com',
          type: 'url',
          placeholder: 'Placeholder site'
        }
      ],

      buttons:  [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary',
          handler: (res) => {
            console.log('Confirm Cancel');
          }
        }, 
        {
          text: 'OK',
          handler: (form) => {
            console.log(form);
          }
        }]
    });
    
    alert.present();
  }

}
