import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewServiceComponent } from '../view-service/view-service.component';
import { AddServiceComponent } from '../add-service/add-service.component';
import { UpdateServiceComponent } from '../update-service/update-service.component';

const routes: Routes = [
  {
    path: '',
    component: ViewServiceComponent
  },
  {
    path: 'add',
    component: AddServiceComponent
  },
  {
    path: 'update',
    component: UpdateServiceComponent
  },
  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
