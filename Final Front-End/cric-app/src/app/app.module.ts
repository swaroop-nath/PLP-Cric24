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
    PlayersUpdateComponent
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
