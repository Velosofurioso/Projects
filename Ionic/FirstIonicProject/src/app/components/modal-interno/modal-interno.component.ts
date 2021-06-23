import { Component, OnInit } from '@angular/core';
import { NavParams } from '@ionic/angular';

@Component({
  selector: 'app-modal-interno',
  templateUrl: './modal-interno.component.html',
  styleUrls: ['./modal-interno.component.scss'],
})
export class ModalInternoComponent implements OnInit {

  nome: string = '';
  constructor(private navParams: NavParams) { 
    console.log(this.navParams.get('nome'));
    this.nome = this.navParams.get('nome');
  }

  ngOnInit() {}

}
