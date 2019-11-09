import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ArchivesModuleComponent } from './archives-module/archives-module.component';
import { BlogsModuleComponent } from './blogs-module/blogs-module.component';
import { TeamsModuleComponent } from './teams-module/teams-module.component';
import { PlayersModuleComponent } from './players-module/players-module.component';
import { SchedulesModuleComponent } from './schedules-module/schedules-module.component';
import { StadiumsModuleComponent } from './stadiums-module/stadiums-module.component';
import { AuthModuleComponent } from './auth-module/auth-module.component';
import { CricketRoutingModule } from './cricket-router/cricket-router-routing.module';
import { ArchivesCreateComponent } from './archives-module/archives-create/archives-create.component';
import { ArchivesRetrieveComponent } from './archives-module/archives-retrieve/archives-retrieve.component';
import { ArchivesUpdateComponent } from './archives-module/archives-update/archives-update.component';
import { HttpClientModule } from '@angular/common/http';
import { StadiumsCreateComponent } from './stadiums-module/stadiums-create/stadiums-create.component';
import { StadiumsRetrieveAllComponent } from './stadiums-module/stadiums-retrieve-all/stadiums-retrieve-all.component';
import { StadiumsRetrieveFieldComponent } from './stadiums-module/stadiums-retrieve-field/stadiums-retrieve-field.component';
import { StadiumsUpdateComponent } from './stadiums-module/stadiums-update/stadiums-update.component';
import { FormsModule } from '@angular/forms';
import { PlayersCreateComponent } from './players-module/players-create/players-create.component';
import { PlayersRetrieveAllComponent } from './players-module/players-retrieve-all/players-retrieve-all.component';
import { PlayersRetrieveFieldComponent } from './players-module/players-retrieve-field/players-retrieve-field.component';
import { PlayersUpdateComponent } from './players-module/players-update/players-update.component';
import { TeamsCreateComponent } from './teams-module/teams-create/teams-create.component';
import { TeamsRetrieveAllComponent } from './teams-module/teams-retrieve-all/teams-retrieve-all.component';
import { TeamsRetrieveFieldComponent } from './teams-module/teams-retrieve-field/teams-retrieve-field.component';
import { TeamsUpdateComponent } from './teams-module/teams-update/teams-update.component';
import { BlogsCreateComponent } from './blogs-module/blogs-create/blogs-create.component';
import { BlogRetrieveFieldComponent } from './blogs-module/blog-retrieve-field/blog-retrieve-field.component';
import { BlogsRetreiveAllComponent } from './blogs-module/blogs-retreive-all/blogs-retreive-all.component';
import { ForgotPasswordComponent } from './auth-module/forgot-password/forgot-password.component';
import { LoginComponent } from './auth-module/login/login.component';
import { ResetPasswordComponent } from './auth-module/reset-password/reset-password.component';
import { SignUpComponent } from './auth-module/sign-up/sign-up.component';
import { LogoutComponent } from './auth-module/logout/logout.component';
import { ScorecardViewComponent } from './archives-module/scorecard-view/scorecard-view.component';
import { TeamViewComponent } from './teams-module/team-view/team-view.component';
import { PlayerViewComponent } from './players-module/player-view/player-view.component';
import { SchedulesCreateComponent } from './schedules-module/schedules-create/schedules-create.component';
import { SchedulesRetrieveComponent } from './schedules-module/schedules-retrieve/schedules-retrieve.component';
import { SchedulesUpdateComponent } from './schedules-module/schedules-update/schedules-update.component';
import { StadiumViewComponent } from './stadiums-module/stadium-view/stadium-view.component';
import { BlogViewComponent } from './blogs-module/blog-view/blog-view.component';
import { ScheduleViewComponent } from './schedules-module/schedule-view/schedule-view.component';

@NgModule({
  declarations: [
    AppComponent,
    ArchivesModuleComponent,
    BlogsModuleComponent,
    TeamsModuleComponent,
    PlayersModuleComponent,
    SchedulesModuleComponent,
    StadiumsModuleComponent,
    AuthModuleComponent,
    ArchivesCreateComponent,
    ArchivesRetrieveComponent,
    ArchivesUpdateComponent,
    StadiumsCreateComponent,
    StadiumsRetrieveAllComponent,
    StadiumsRetrieveFieldComponent,
    StadiumsUpdateComponent,
    PlayersCreateComponent,
    PlayersRetrieveAllComponent,
    PlayersRetrieveFieldComponent,
    PlayersUpdateComponent,
    TeamsCreateComponent,
    TeamsRetrieveAllComponent,
    TeamsRetrieveFieldComponent,
    TeamsUpdateComponent,
    BlogsCreateComponent,
    BlogRetrieveFieldComponent,
    BlogsRetreiveAllComponent,
    ForgotPasswordComponent,
    LoginComponent,
    ResetPasswordComponent,
    SignUpComponent,
    LogoutComponent,
    ScorecardViewComponent,
    TeamViewComponent,
    PlayerViewComponent,
    SchedulesCreateComponent,
    SchedulesRetrieveComponent,
    SchedulesUpdateComponent,
    StadiumViewComponent,
    BlogViewComponent,
    ScheduleViewComponent,
  ],
  imports: [
    BrowserModule,
    CricketRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
