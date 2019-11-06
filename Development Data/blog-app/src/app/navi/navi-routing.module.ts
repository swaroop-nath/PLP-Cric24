import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddblogComponent } from '../addblog/addblog.component';
import { ListblogComponent } from '../listblog/listblog.component';
import { SearchblogComponent } from '../searchblog/searchblog.component';

const routes: Routes = [
  {path:"add",component: AddblogComponent},
  {path:"list",component:ListblogComponent},
  {path:"search",component:SearchblogComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
