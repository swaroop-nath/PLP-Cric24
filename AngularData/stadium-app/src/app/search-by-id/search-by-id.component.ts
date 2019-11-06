import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-search-by-id',
  templateUrl: './search-by-id.component.html',
  styleUrls: ['./search-by-id.component.css']
})
export class SearchByIDComponent implements OnInit {

  stadium: StadiumModel;
  id: number;
  submitted:boolean=false;
  deleted : boolean;
  exists : boolean = false;

  constructor(private service:StadiumdetailsService, private route: Router) { }

  ngOnInit() {
    this.stadium = new StadiumModel();
  }

  findStadiumById() {
    this.service.findStadiumById(this.id).subscribe(data => {
      this.stadium = data;
      this.submitted=true;
      if(this.stadium != null)
        this.exists = true;
    });
  }

  delete(){
    var ans = confirm("Are you sure you want to delete ?");
    if(ans){
      console.log(this.stadium.stadiumId)
      this.service.deleteStadium(this.stadium.stadiumId).subscribe(val => {
        this.route.navigate(['list']);
      });
      
    }

  }
}
