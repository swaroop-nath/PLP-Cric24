import { Component, OnInit } from '@angular/core';
import { Stadium } from 'src/app/model/stadium.model';
import { StadiumsService } from '../stadiums-service/stadiums-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stadiums-update',
  templateUrl: './stadiums-update.component.html',
  styleUrls: ['./stadiums-update.component.css']
})
export class StadiumsUpdateComponent implements OnInit {

  stadium : Stadium;
  submitted:boolean=false;
  
  constructor(private service:StadiumsService, private route: Router) {
    this.stadium = service.transitStadium;
   }

  ngOnInit() {
  }

  update(){
    this.service.updateStadium(this.stadium).subscribe(data => {
      this.stadium = data;
      this.submitted = true;
    });
  }
}
