import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.page.html',
  styleUrls: ['./content.page.scss'],
})
export class ContentPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  logScrollStart() {
    console.log('Iniciou a Interação com o Scroll');
  }

  logScrollEnd() {
    console.log('Scroll parou de ser utilizado');
  }

  logScrolling(event) {
    console.log(event);
  }

}
