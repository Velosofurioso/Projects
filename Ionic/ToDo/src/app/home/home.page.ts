import { Component } from '@angular/core';
import { ActionSheetController, AlertController, ToastController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  tasks : any[] = [];
  constructor(private alertCtrl : AlertController, private toastCtrl : ToastController, private actionSheetCtrl: ActionSheetController) {
     let localTasks = localStorage.getItem('taskDb');
    if(localTasks != null){
      this.tasks = JSON.parse(localTasks);
    }
  }

  async showAdd() {
    const alert = await this.alertCtrl.create({
      header: 'O que deseja Fazer?',
      inputs: [
        {
          name: 'task',
          type: 'text',
          placeholder: 'Comprar Pão'
        }
      ],
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel',
          cssClass: 'secondary',
          handler: () => {
            console.log('clicked cancel');
          }
        },
        {
          text: 'Adicionar',
          handler: (form) => {
            this.add(form.task);
          }
        }
      ]
    });
    await alert.present();
  }

  async add(task: string) {
    if(task.trim().length < 1) {
      const toast = await this.toastCtrl.create({
        message: 'Adicione uma tarefa primeiro!',
        duration: 2000,
        color: 'danger',
        position: 'top',
        animated: true
      });
      await toast.present();
      return;
    }

    let newTask = {
      name: task, 
      done: false
    };

    this.tasks.push(newTask);

    this.saveInLocalStorage();
  }

  saveInLocalStorage() {
    localStorage.setItem('taskDb', JSON.stringify(this.tasks));
  }

  async openActions(task) {
    const actionSheet  = await this.actionSheetCtrl.create({
      header: 'O QUE DESEJA FAZER?',
      buttons: [
        {
          text: task.done ? 'Desmarcar' : 'Marcar',
          icon: task.done ? 'radio-button-off' : 'checkmark-circle',
          handler: () => {
            task.done = !task.done;
            this.saveInLocalStorage();
          }
        },
        {
          text: 'Cancelar',
          icon: 'close',
          role: 'cancel',
          handler: () => {
            console.log('cancel Clicked');
          }
        }
      ]
    });
    await actionSheet.present();
  }

  delete(task: any) {
    this.tasks = this.tasks.filter(tasksArray => task != tasksArray);
    this.saveInLocalStorage();
  }

}
