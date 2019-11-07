import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/model/player.model';
import { PlayersService } from '../players-service/players-service.service';
import { Router } from '@angular/router';
import * as $ from 'jquery';

@Component({
  selector: 'app-players-retrieve-all',
  templateUrl: './players-retrieve-all.component.html',
  styleUrls: ['./players-retrieve-all.component.css']
})
export class PlayersRetrieveAllComponent implements OnInit {
  players:Player[];

  constructor(private service:PlayersService, private router: Router) {}

  ngOnInit() {
    this.service.listPlayer().subscribe(data => this.players = data);
    this.onStart();

    $(window).on('popstate', function(event) {
      $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#archives-outlet').animate({height: '100%', width: '25%'}, 500).show()
      $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
      $('#players-outlet').animate({height: '0px', width: '0px'}).hide()
    });
  }

  onStart() {
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#teams-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#stadiums-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#players-outlet').animate({height: '100%', width: '100%'}).show()
  }

  delete(index: number){
    let idDelete = this.players[index].playerId
    var ans = confirm("Are You Sure You Want To Delete?")
    if(ans){
      this.players.splice(index,1);
      this.service.deletePlayer(idDelete).subscribe();
    }
  }

  update(index: number) {
    this.service.transitPlayer = this.players[index]
    this.router.navigate(['players-update'])
  }
}
