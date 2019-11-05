import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddblogComponent } from '../addblog/addblog.component';

const routes: Routes = [
  {path:"add",component: AddblogComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
