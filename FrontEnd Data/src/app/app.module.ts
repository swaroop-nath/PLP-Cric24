import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthGuard } from './guard/auth-guard.service';
import { DeactivateGuard } from './guard/deactivate-guard.service';
import { AuthService } from './auth/auth.service';
import { HttpErrorInterceptor } from './http-interceptor';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { GetBloggersComponent } from './get-bloggers/get-bloggers.component';
import { RoleGuard } from './guard/role-guard.service';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    ResetPasswordComponent,
    LoginComponent,
    LogoutComponent,
    ForgotPasswordComponent,
    GetBloggersComponent
  ],
  imports: [
    BrowserModule, NaviRoutingModule, FormsModule, HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  },AuthGuard, DeactivateGuard, RoleGuard, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
