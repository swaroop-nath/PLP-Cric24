import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { ResetPasswordComponent } from '../reset-password/reset-password.component';
import { AuthGuard } from '../guard/auth-guard.service';
import { LogoutComponent } from '../logout/logout.component';
import { DeactivateGuard } from '../guard/deactivate-guard.service';
import { ForgotPasswordComponent } from '../forgot-password/forgot-password.component';
import { GetBloggersComponent } from '../get-bloggers/get-bloggers.component';

const routes: Routes = [
  {path:'login', component:LoginComponent},
  {path:'signup', component:SignupComponent},
  {path:'logout', component:LogoutComponent},
  {path:'forgotpassword', component:ForgotPasswordComponent},
  {path:'getall', component:GetBloggersComponent},
  {path:'reset', component:ResetPasswordComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
