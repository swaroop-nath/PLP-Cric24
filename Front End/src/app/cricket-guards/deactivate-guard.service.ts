import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../auth-module/auth-service/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class DeactivateGuard implements CanActivate {

  constructor(private authService:AuthService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.authService.isUserLoggedIn()=="admin"||this.authService.isUserLoggedIn()=="blogger"){
      return false;
    }
    else{
      return true;
    }
  }
}
