import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/model/player.model';
import { PlayersService } from '../players-service/players-service.service';

@Component({
  selector: 'app-players-retrieve-field',
  templateUrl: './players-retrieve-field.component.html',
  styleUrls: ['./players-retrieve-field.component.css']
})
export class PlayersRetrieveFieldComponent implements OnInit {
  players:Player[];
  play:Player;
  pname:string;
  id:number;
  submitted:boolean=false;

  constructor(private service:PlayersService) { }

  ngOnInit() {
    this.players=[];
    this.play=new Player();
  }

  findPlayerById(){
    this.service.findPlayerById(this.id).subscribe(data => {
      this.play = data;
      this.submitted=true});
  }

  findPlayerByName(){
    this.service.findPlayerByName(this.pname).subscribe(p => {
      this.players=p;
      this.submitted=true;
    });
    
  }
  
}
