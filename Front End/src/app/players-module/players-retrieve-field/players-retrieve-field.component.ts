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
  pname:string;
  id:number;
  submitted:boolean=false;

  constructor(private service:PlayersService) { }

  ngOnInit() {
    this.players=[];
  }

  findPlayerById(){
    this.service.findPlayerById(this.id).subscribe(fetchedPlayer => {
      this.players = [];
      this.players.push(fetchedPlayer);
      this.submitted=true;
    });
  }

  findPlayerByName(){
    this.service.findPlayerByName(this.pname).subscribe(fetchedPlayers => {
      this.players = [];
      this.players = fetchedPlayers;
      this.submitted=true;
    });
    
  }
  
}
