import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  stadium : StadiumModel;
  submitted:boolean=false;
  
  constructor(private service:StadiumdetailsService, private route: Router) {
    this.stadium = new StadiumModel();
   }

  ngOnInit() {
  }

  update(){
      this.service.updateStadium(this.stadium).subscribe(data => {
        this.stadium=data;
        this.submitted=true;
      });
      this.stadium=new StadiumModel();
    }
  }
