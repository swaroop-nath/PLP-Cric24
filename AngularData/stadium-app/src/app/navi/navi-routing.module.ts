import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from '../home/home.component';
import { AddComponent } from '../add/add.component';
import { ListComponent } from '../list/list.component';
import { SearchByIDComponent } from '../search-by-id/search-by-id.component';


const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'add',component:AddComponent},
  {path:'list',component:ListComponent},
  {path:'searchById',component:SearchByIDComponent},
  {path:'**',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
