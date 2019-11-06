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


const routes: Routes = [
  {
    path: '',
    component: PlayersRetrieveAllComponent,
  },
  {
    path: 'players-update',
    component: PlayersUpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CricketRoutingModule { }
