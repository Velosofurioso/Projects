import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TabMapPageRoutingModule } from './tab-map-routing.module';

import { TabMapPage } from './tab-map.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TabMapPageRoutingModule
  ],
  declarations: [TabMapPage]
})
export class TabMapPageModule {}
