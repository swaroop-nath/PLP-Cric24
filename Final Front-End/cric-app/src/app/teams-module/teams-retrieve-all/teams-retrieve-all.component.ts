import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/model/team.model';
import { TeamsService } from '../teams-service/teams-service.service';

@Component({
  selector: 'app-teams-retrieve-all',
  templateUrl: './teams-retrieve-all.component.html',
  styleUrls: ['./teams-retrieve-all.component.css']
})
export class TeamsRetrieveAllComponent implements OnInit {
  teams:Team[];
  constructor(private service:TeamsService) { }

  ngOnInit() {
    this.service.fetchAllTeams().subscribe(fetchedTeams => this.teams = fetchedTeams);
  }
  delete(index:number){
    let idDelete = this.teams[index].teamId
    var ans = confirm("Are You Sure You want to delete?")
    if(ans){
      this.teams.splice(index,1)
      this.service.deleteTeam(idDelete).subscribe(); // delete from service
    }
  }
}
