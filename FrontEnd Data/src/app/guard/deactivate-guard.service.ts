import { Injectable } from '@angular/core';
import { CanDeactivate, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { AuthService } from '../auth/auth.service';
import { SignupComponent } from '../signup/signup.component';

@Injectable({
  providedIn: 'root'
})
export class DeactivateGuard implements CanDeactivate<SignupComponent> {

  constructor(private service:AuthService){}

  canDeactivate(component: SignupComponent, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState: RouterStateSnapshot): boolean{
    if(this.service.isUserLoggedIn()==1||this.service.isUserLoggedIn()==2){      
      // console.log(this.service.isUserLoggedIn()==1||this.service.isUserLoggedIn()==2);
      return true;
    }
    return false;
  }

}
