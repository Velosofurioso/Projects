import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkbox',
  templateUrl: './checkbox.page.html',
  styleUrls: ['./checkbox.page.scss'],
})
export class CheckboxPage implements OnInit {

  mounths : any[] = [
    {mounthName: 'January', value: 1, marked: false},
    {mounthName: 'February', value: 2, marked: true},
    {mounthName: 'March', value: 3, marked: false},
    {mounthName: 'April', value: 4, marked: false},
    {mounthName: 'May', value: 5, marked: false},
  ];
  constructor() { }

  ngOnInit() {
    console.log(this.mounths);
  }

  showMarkedMounths() {
    this.mounths.forEach((mounth) => mounth.marked ? console.log(mounth.mounthName) : null);
  }



}
