import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from '../auth-module/auth-service/auth-service.service';
import { CricketService } from '../cricket-service/cricket-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate{

  constructor(private authService:AuthService, private cricService: CricketService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if(this.authService.isUserLoggedIn()=="admin"||this.authService.isUserLoggedIn()=="blogger"){
      return true
    }
    else{
      this.cricService.homeComponents.forEach(homeComponent => homeComponent.onBadRouteProvided())
      this.router.navigate([''])
      return false;
    }
  }

 
}
