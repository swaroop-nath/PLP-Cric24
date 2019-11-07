import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/model/player.model';
import { PlayersService } from '../players-service/players-service.service';
import * as $ from 'jquery';
import { Router } from '@angular/router';

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

  constructor(private service:PlayersService, private router: Router) { }

  ngOnInit() {
    this.players=[];
  }

  onStart() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#teams-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#stadiums-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#players-outlet').animate({height: '100%', width: '100%'}).show()
  }

  initializeComponent() {
    this.onStart();
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

  viewPlayer(player: Player) {
    this.service.transitPlayer = player;
    this.service.addToBackStack(this);
    this.router.navigate([{outlets: {'players': ['player-view']}}]), {relativeTo: this.service.getParentRoute()}
  }
  
}
