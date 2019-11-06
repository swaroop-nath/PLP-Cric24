import { Component, OnInit } from '@angular/core';
import { Stadium } from 'src/app/model/stadium.model';
import { StadiumsService } from '../stadiums-service/stadiums-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stadiums-create',
  templateUrl: './stadiums-create.component.html',
  styleUrls: ['./stadiums-create.component.css']
})
export class StadiumsCreateComponent implements OnInit {

  stadium : Stadium;
  id : number;

  constructor(private stadiumsService: StadiumsService, private route: Router) {
    this.stadium = new Stadium();
   }

  ngOnInit() {
  }

  addStadium() {
    this.stadiumsService.saveStadium(this.stadium).subscribe(savedStadium => {
      this.stadium = new Stadium();
      // this.route.navigate(['list']);
    });
  }
}
