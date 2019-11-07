import { Component, OnInit } from '@angular/core';
import { PlayersService } from '../players-service/players-service.service';
import { Player } from 'src/app/model/player.model';
import * as $ from 'jquery';
import { Router } from '@angular/router';

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrls: ['./player-view.component.css']
})
export class PlayerViewComponent implements OnInit {

  receivedPlayer: Player;

  constructor(private playerService: PlayersService, private router: Router) { }

  ngOnInit() {
    this.receivedPlayer = this.playerService.transitPlayer; 
    console.log(this.receivedPlayer)
    this.onStart();

    $(window).on('popstate', (event) => {
      $('#players-outlet').animate({height: '0px', width: '0px'}).hide()
      this.playerService.getFromBackStack().initializeComponent();
    });
  }

  onStart() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#teams-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#players-outlet').animate({height: '100%', width: '100%'}).show()
  }

  update() {
    this.playerService.transitPlayer = this.receivedPlayer;
    this.router.navigate([{outlets: {'players': ['update-player']}}], {relativeTo: this.playerService.getParentRoute()})
  }

}
