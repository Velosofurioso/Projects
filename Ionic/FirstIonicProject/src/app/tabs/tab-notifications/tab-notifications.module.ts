import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TabNotificationsPageRoutingModule } from './tab-notifications-routing.module';

import { TabNotificationsPage } from './tab-notifications.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabNotificationsPageRoutingModule
  ],
  declarations: [TabNotificationsPage]
})
export class TabNotificationsPageModule {}
