import { Component, OnInit } from '@angular/core';
import { StadiumdetailsService } from '../services/stadiumdetails.service';
import { StadiumModel } from '../model/stadium';

@Component({
  selector: 'app-list-by-id',
  templateUrl: './list-by-id.component.html',
  styleUrls: ['./list-by-id.component.css']
})
export class ListByIdComponent implements OnInit {

  stadiums: StadiumModel;

  constructor(private service: StadiumdetailsService) { }

  ngOnInit() {
    this.service.listStadiumByID().subscribe(data => this.stadiums=data)
  }

  // delete(stadium: StadiumModel){
  //      var ans = confirm("Are you sure you want to delete ?");
  //      if(ans)
  //      this.service.deleteStadium(stadium.stadiumId).subscribe();
  //   }
}
