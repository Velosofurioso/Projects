import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabNotificationsPage } from './tab-notifications.page';

const routes: Routes = [
  {
    path: '',
    component: TabNotificationsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabNotificationsPageRoutingModule {}
