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
    ArchivesUpdateComponent
  ],
  imports: [
    BrowserModule,
    CricketRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
