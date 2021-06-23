import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-componentes-visuais',
  templateUrl: './componentes-visuais.page.html',
  styleUrls: ['./componentes-visuais.page.scss'],
})
export class ComponentesVisuaisPage implements OnInit {

  menus : any = [];
  constructor(private navCtrl: NavController) { 
    this.menus = [
      { title: 'Action-Sheet', url: 'action-sheet', icon: 'construct' },
      { title: 'Alert', url: 'alert', icon: 'construct' },
      { title: 'Animação', url: 'animacao', icon: 'construct' },
      { title: 'Badge', url: 'badge', icon: 'construct' },
      { title: 'Botões', url: 'botao', icon: 'construct' },
      { title: 'Card', url: 'card', icon: 'construct' },
      { title: 'Checkbox', url: 'checkbox', icon: 'construct' },
      { title: 'Chip', url: 'chip', icon: 'construct' },
      { title: 'Content', url: 'content', icon: 'construct' },
      { title: 'DateTime', url: 'datetime', icon: 'construct' },
      { title: 'FAB', url: 'fab', icon: 'construct' },
      { title: 'Grid', url: 'grid', icon: 'construct' },
      { title: 'Infinite Scroll', url: 'infinitescroll', icon: 'construct' },
      { title: 'Input', url: 'input', icon: 'construct' },
      { title: 'List', url: 'list', icon: 'construct' },
      { title: 'Loading', url: 'loading', icon: 'construct' },
      { title: 'Modal', url: 'modal', icon: 'construct' },
      { title: 'Navegação', url: 'navegacao', icon: 'paper-plane' },
      { title: 'Popover', url: 'popover', icon: 'construct' },
      { title: 'Progress Bar', url: 'progressbar', icon: 'construct' },
      { title: 'Radio', url: 'radio', icon: 'construct' },
      { title: 'Range', url: 'range', icon: 'construct' },
      { title: 'Refresher', url: 'refresher', icon: 'construct' },
      { title: 'Reorder', url: 'reorder', icon: 'construct' },
      { title: 'SearchBar', url: 'searchbar', icon: 'construct' },
      { title: 'Segment', url: 'segment', icon: 'construct' },
      { title: 'Select', url: 'select', icon: 'construct' },
      { title: 'Slides', url: 'slides', icon: 'construct' },
      { title: 'Spinner', url: 'spinner', icon: 'construct' },
      { title: 'Split Pane', url: 'split-pane', icon: 'construct' },
      { title: 'Tabs', url: 'tabs', icon: 'construct' },
      { title: 'Toast', url: 'toast', icon: 'construct' },
      { title: 'Toggle', url: 'toggle', icon: 'construct' },
    ];
  }

  ngOnInit() {
  }

  showPage(pageUrl: string) {
    this.navCtrl.navigateForward(pageUrl);
  }

}
