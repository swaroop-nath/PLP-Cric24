import { Injectable } from '@angular/core';
import { AuthService } from '../auth-module/auth-service/auth-service.service';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RoleGuardService {

  constructor(private authService:AuthService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.authService.isUserLoggedIn()=="admin"){
      return true
    }
    else{
      return false;
    }
  }
}
