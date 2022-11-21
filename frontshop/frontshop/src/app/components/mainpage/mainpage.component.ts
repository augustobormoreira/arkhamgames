import { Component, OnInit, ViewChild } from '@angular/core';
import { faSquarePlus } from '@fortawesome/free-regular-svg-icons';
import { AddproductComponent } from '../addproduct/addproduct.component';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  @ViewChild('myModal') modal!: AddproductComponent;

  faSquarePlus = faSquarePlus;

  constructor() {}

  open(){
    this.modal.openModalService();
  }

  

  ngOnInit(): void {
  }

}
