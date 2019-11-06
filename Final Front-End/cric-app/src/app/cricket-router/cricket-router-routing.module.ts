import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArchivesRetrieveComponent } from '../archives-module/archives-retrieve/archives-retrieve.component';
import { StadiumsCreateComponent } from '../stadiums-module/stadiums-create/stadiums-create.component';
import { StadiumsRetrieveAllComponent } from '../stadiums-module/stadiums-retrieve-all/stadiums-retrieve-all.component';
import { StadiumsRetrieveFieldComponent } from '../stadiums-module/stadiums-retrieve-field/stadiums-retrieve-field.component';
import { StadiumsUpdateComponent } from '../stadiums-module/stadiums-update/stadiums-update.component';


const routes: Routes = [
  {
    path: '',
    component: StadiumsRetrieveFieldComponent
  },
  {
    path: 'stadiums-update',
    component: StadiumsUpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CricketRoutingModule { }
