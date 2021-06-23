import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
      path: '',
      component: TabsPage,
      children: [
        {
            path: 'home',
            loadChildren: () => import('../../tabs/tab-home/tab-home.module').then( m => m.TabHomePageModule)
        },
        {
          path: 'map',
          loadChildren: () => import('../../tabs/tab-map/tab-map.module').then( m => m.TabMapPageModule)
        },
        {
          path: 'notifications',
          loadChildren: () => import('../../tabs/tab-notifications/tab-notifications.module').then( m => m.TabNotificationsPageModule)
        },
        {
          path: '',
          redirectTo: 'home', 
          pathMatch: 'full'
        },
      ]
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TabsPageRoutingModule {}
