import { Component, OnInit } from '@angular/core';
import { Player } from '../model/player';
import { PlayerService } from '../player/player.service';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {
  players:Player[];
  play:Player;
  pname:string;
  id:number;
  submitted:boolean=false;

  constructor(private service:PlayerService) { 
    
  }

  ngOnInit() {
    this.players=[];
    this.play=new Player();
  }

  findPlayerById(){
    this.service.findPlayerById(this.id).subscribe(data => {
      this.play = data;this.submitted=true});
  }

  findPlayerByName(){
    this.service.findPlayerByName(this.pname).subscribe(p => {
      this.players=p;
      this.submitted=true;
    });
    
  }
  
}
