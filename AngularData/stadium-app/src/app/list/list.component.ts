import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';

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

   delete(id:number){
    var ans = confirm("Are you sure you want to delete ?");
    if(ans)
     this.service.deleteStadium(id).subscribe();
  }

}
