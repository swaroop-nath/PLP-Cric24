import { Component, OnInit } from '@angular/core';
import { Team } from '../model/team';
import { TeamService } from '../team/team.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  teams:Team[];
  constructor(private service:TeamService) { }

  ngOnInit() {
    this.service.listAll().subscribe(data => this.teams = data);
  }
  delete(index:number){
    let idDelete = this.teams[index].teamId
    var ans = confirm("Are You Sure You want to delete?")
    if(ans){
      this.teams.splice(index,1)
      this.service.deleteTeam(idDelete); // delete from service
    }

}
}