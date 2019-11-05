import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';

@Component({
  selector: 'app-search-by-id',
  templateUrl: './search-by-id.component.html',
  styleUrls: ['./search-by-id.component.css']
})
export class SearchByIDComponent implements OnInit {

  stadium: StadiumModel;
  id: number;
  submitted:boolean=false;
  err:any;
  constructor(private service:StadiumdetailsService) { }

  ngOnInit() {
    this.stadium = new StadiumModel();
  }

  findStadiumById() {
    this.service.findStadiumById(this.id).subscribe(data => {
      this.stadium = data;
      this.submitted=true;
    });
  }

   
}
