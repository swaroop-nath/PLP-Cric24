import { Injectable } from '@angular/core';
import { CanDeactivate, RouterStateSnapshot, ActivatedRouteSnapshot, CanActivate } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { AuthService } from '../auth/auth.service';
import { SignupComponent } from '../signup/signup.component';

@Injectable({
  providedIn: 'root'
})
export class DeactivateGuard implements CanActivate{
 
  constructor(private service:AuthService){}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.service.isUserLoggedIn()==1||this.service.isUserLoggedIn()==2){
      return false;
    }
    return true;
  }
 

}
