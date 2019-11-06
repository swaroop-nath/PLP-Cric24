import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';

@Component({
  selector: 'app-list-by-country',
  templateUrl: './list-by-country.component.html',
  styleUrls: ['./list-by-country.component.css']
})
export class ListByCountryComponent implements OnInit {

  stadiums: StadiumModel[];
  stadium:StadiumModel;
  country: string;
  submitted:boolean=false;
  
  constructor(private service: StadiumdetailsService) {
   }

  ngOnInit() {
    this.stadium=new StadiumModel();
  }

  byCountry(){
    this.service.listByCountry(this.country).subscribe(data => {
      this.stadiums = data;
      this.submitted=true;
    });
}
}
