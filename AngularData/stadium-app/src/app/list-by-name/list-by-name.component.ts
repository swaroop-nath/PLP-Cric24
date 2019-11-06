import { Component, OnInit } from '@angular/core';
import { StadiumModel } from '../model/stadium';
import { StadiumdetailsService } from '../services/stadiumdetails.service';

@Component({
  selector: 'app-list-by-name',
  templateUrl: './list-by-name.component.html',
  styleUrls: ['./list-by-name.component.css']
})
export class ListByNameComponent implements OnInit {

  stadiums: StadiumModel[];
  stadium:StadiumModel;
  name: string;
  submitted:boolean=false;

  constructor(private service : StadiumdetailsService) { }

  ngOnInit() {
    this.stadium=new StadiumModel();
  }

  byName(){
    this.service.listByName(this.name).subscribe(data => {
      this.stadiums = data;
      this.submitted=true;
    });
  }

}
