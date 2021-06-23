import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reorder',
  templateUrl: './reorder.page.html',
  styleUrls: ['./reorder.page.scss'],
})
export class ReorderPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  doReorder(event) {
    
    console.log('Dragged gfrom Item: ', event.detail.from, 'to: ', event.detail.to);
    event.detail.complete();
  }

}
