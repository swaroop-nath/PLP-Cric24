import { Component, OnInit } from '@angular/core';
import { StadiumdetailsService } from '../services/stadiumdetails.service';
import { StadiumModel } from '../model/stadium';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  stadium : StadiumModel;
  id : number;

  constructor(private service:StadiumdetailsService, private route: Router) {
    this.stadium = new StadiumModel();
   }

  ngOnInit() {
  }

  add() {
    this.service.saveStadium(this.stadium).subscribe(data => this.stadium=data);
    this.stadium=new StadiumModel();
    this.route.navigate(['list']);
  }
}
