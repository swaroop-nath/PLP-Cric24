import { Component, OnInit } from '@angular/core';
import { Stadium } from 'src/app/model/stadium.model';
import { StadiumsService } from '../stadiums-service/stadiums-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stadiums-retrieve-field',
  templateUrl: './stadiums-retrieve-field.component.html',
  styleUrls: ['./stadiums-retrieve-field.component.css']
})
export class StadiumsRetrieveFieldComponent implements OnInit {

  stadiums: Stadium[];
  stadium: Stadium;
  country: string;
  name: string;
  submitted: boolean = false;
  id: number;
  error: boolean = false;
  
  constructor(private service: StadiumsService, private router: Router) {
   }

  ngOnInit() {
    this.stadiums = [];
  }

  fetchByCountry(){
    this.service.listByCountry(this.country).subscribe(data => {
      this.stadiums = data;
      this.submitted = true;
    });
  }

  fetchByName(){
    this.service.listByName(this.name).subscribe(data => {
      this.stadiums = data;
      this.submitted = true;
    });
  }

  fetchById() {
    this.service.findStadiumById(this.id).subscribe(data => {
      this.stadiums.push(data);
      this.submitted = true;
    });
  }

}
