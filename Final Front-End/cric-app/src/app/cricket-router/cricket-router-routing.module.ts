import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArchivesRetrieveComponent } from '../archives-module/archives-retrieve/archives-retrieve.component';
import { StadiumsCreateComponent } from '../stadiums-module/stadiums-create/stadiums-create.component';
import { StadiumsRetrieveAllComponent } from '../stadiums-module/stadiums-retrieve-all/stadiums-retrieve-all.component';
import { StadiumsRetrieveFieldComponent } from '../stadiums-module/stadiums-retrieve-field/stadiums-retrieve-field.component';
import { StadiumsUpdateComponent } from '../stadiums-module/stadiums-update/stadiums-update.component';
import { PlayersCreateComponent } from '../players-module/players-create/players-create.component';
import { PlayersRetrieveAllComponent } from '../players-module/players-retrieve-all/players-retrieve-all.component';
import { PlayersUpdateComponent } from '../players-module/players-update/players-update.component';
import { PlayersRetrieveFieldComponent } from '../players-module/players-retrieve-field/players-retrieve-field.component';
import { TeamsCreateComponent } from '../teams-module/teams-create/teams-create.component';
import { TeamsRetrieveAllComponent } from '../teams-module/teams-retrieve-all/teams-retrieve-all.component';
import { TeamsRetrieveFieldComponent } from '../teams-module/teams-retrieve-field/teams-retrieve-field.component';
import { TeamsUpdateComponent } from '../teams-module/teams-update/teams-update.component';


const routes: Routes = [
  {
    path: '',
    component: PlayersCreateComponent,
  },
  {
    path: 'teams-update',
    component: TeamsUpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CricketRoutingModule { }
