import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FindComponent } from '../find/find.component';
import { AddComponent } from '../add/add.component';
import { ListComponent } from '../list/list.component';
import { UpdateComponent } from '../update/update.component';

const routes: Routes = [{path:"",redirectTo : "/find", pathMatch : "full"},
{path:"find",component:FindComponent},
{path:"add",component:AddComponent},
{path:"list",component:ListComponent},
{path:"update", component:UpdateComponent},
{path:"**",redirectTo : "/find", pathMatch : "full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
