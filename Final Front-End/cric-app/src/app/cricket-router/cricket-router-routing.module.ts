import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArchivesRetrieveComponent } from '../archives-module/archives-retrieve/archives-retrieve.component';


const routes: Routes = [
  {
    path: '',
    component: ArchivesRetrieveComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CricketRoutingModule { }
