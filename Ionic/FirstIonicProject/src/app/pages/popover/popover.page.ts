import { Component, OnInit } from '@angular/core';
import { PopoverController } from '@ionic/angular';
import { ModalInternoComponent } from 'src/app/components/modal-interno/modal-interno.component';

@Component({
  selector: 'app-popover',
  templateUrl: './popover.page.html',
  styleUrls: ['./popover.page.scss'],
})
export class PopoverPage implements OnInit {

  constructor(private popoverCtrl: PopoverController) { }

  ngOnInit() {
  }

  async openPopover(event) {
    let popover = await this.popoverCtrl.create({
      component: ModalInternoComponent,
      event: event,
      translucent: true
    });

    return await popover.present();
  }

}
