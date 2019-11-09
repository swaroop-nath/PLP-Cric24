import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private service:AuthService, private route:Router) { }
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.service.isUserLoggedIn()==1||this.service.isUserLoggedIn()==2){
      console.log(this.service.isUserLoggedIn())
      return true;
    }

    this.route.navigate(['login']);
    return false;
  }

 
}
