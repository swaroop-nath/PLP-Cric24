import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-list-by-country',
  templateUrl: './list-by-country.component.html',
  styleUrls: ['./list-by-country.component.css']
})
export class ListByCountryComponent implements OnInit {

  stadiums: StadiumModel;
  stadium: StadiumModel[];
  country: string;
  
  constructor(private service: StadiumdetailsService, public http: HttpClient) {
    this.stadiums= new StadiumModel();
   }

  ngOnInit() {
  }

  listByCountry(country:string){
    return this.http.get<StadiumModel>("http://localhost:8890/stadium/country/" +this.country).subscribe(data => this.stadiums=data);
  }
}
