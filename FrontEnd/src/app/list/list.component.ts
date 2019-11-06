import { Component, OnInit } from '@angular/core';
import { Player } from '../model/player';
import { PlayerService } from '../player/player.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  players:Player[];

  constructor(private service:PlayerService) {
    
   }

  ngOnInit() {
    this.service.listPlayer().subscribe(data => this.players = data);
  }

  delete(index: number){
    let idDelete = this.players[index].playerId
    var ans = confirm("Are You Sure You Want To Delete?")
    if(ans){
      this.players.splice(index,1);
      this.service.deletePlayer(idDelete);
    }
  }

}
