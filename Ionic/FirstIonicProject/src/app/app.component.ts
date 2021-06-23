import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Componentes Visuais', url: 'componentes-visuais', icon: 'construct' },
    { title: 'Componentes Nativos', url: 'componentes-nativos', icon: 'construct' },
    { title: 'Api Externa', url: 'api', icon: 'construct' },

  ];
  public labels = ['Family', 'Friends', 'Notes', 'Work', 'Travel', 'Reminders'];
  constructor() {}
}
