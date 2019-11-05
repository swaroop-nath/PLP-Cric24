import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';
import { t, st } from '@angular/core/src/render3';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  stadiums: StadiumModel[];

  constructor(private service: StadiumdetailsService) { }

  ngOnInit() {
    this.service.listStadium().subscribe(data => this.stadiums=data);
  }

   delete(stadium:StadiumModel){
    var ans = confirm("Are you sure you want to delete ?");
    if(ans){
      console.log(stadium.stadiumId)
      this.service.deleteStadium(stadium.stadiumId).subscribe(data => this.stadiums=this.stadiums.filter(z => z !==stadium));
    }
   
  }

}
