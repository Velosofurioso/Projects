import { Component, OnInit } from '@angular/core';
import { ActionSheetController } from '@ionic/angular';

@Component({
  selector: 'app-action-sheet',
  templateUrl: './action-sheet.page.html',
  styleUrls: ['./action-sheet.page.scss'],
})
export class ActionSheetPage implements OnInit {

  constructor(private actionSheetCtrl: ActionSheetController) { }

  ngOnInit() {
  }

  async actionSheet() {
    const actionSheet = await this.actionSheetCtrl.create({
      header: 'Albuns',
      buttons: [{
        text: 'Delete',
        role: 'destructive',
        icon: 'trash',
        handler: () => {
          console.log('Delete Clicked');
        }
      },
      {
        text: 'Share',
        icon: 'share',
        handler: () => {
          console.log('Share Clicked');
        }
      },
      {
        text: 'Play (open Modal)',
        icon: 'arrow-dropright-circle',
        handler: () => {
          console.log('Play Clicked');
        }
      },
      {
        text: 'Favorite',
        icon: 'heart',
        handler: () => {
          console.log('Favorite Clicked');
        }
      },
      {
        text: 'Cancel',
        role: 'cancel',
        icon: 'close',
        handler: () => {
          console.log('Cancel Clicked');
        }
      }]
    });

    actionSheet.present();
  }

}
