import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArchivesRetrieveComponent } from '../archives-module/archives-retrieve/archives-retrieve.component';
import { StadiumsCreateComponent } from '../stadiums-module/stadiums-create/stadiums-create.component';
import { StadiumsRetrieveAllComponent } from '../stadiums-module/stadiums-retrieve-all/stadiums-retrieve-all.component';
import { StadiumsRetrieveFieldComponent } from '../stadiums-module/stadiums-retrieve-field/stadiums-retrieve-field.component';
import { StadiumsUpdateComponent } from '../stadiums-module/stadiums-update/stadiums-update.component';
import { PlayersCreateComponent } from '../players-module/players-create/players-create.component';
import { PlayersRetrieveAllComponent } from '../players-module/players-retrieve-all/players-retrieve-all.component';
import { PlayersUpdateComponent } from '../players-module/players-update/players-update.component';
import { PlayersRetrieveFieldComponent } from '../players-module/players-retrieve-field/players-retrieve-field.component';
import { TeamsCreateComponent } from '../teams-module/teams-create/teams-create.component';
import { TeamsRetrieveAllComponent } from '../teams-module/teams-retrieve-all/teams-retrieve-all.component';
import { TeamsRetrieveFieldComponent } from '../teams-module/teams-retrieve-field/teams-retrieve-field.component';
import { TeamsUpdateComponent } from '../teams-module/teams-update/teams-update.component';
import { BlogsCreateComponent } from '../blogs-module/blogs-create/blogs-create.component';
import { BlogsRetreiveAllComponent } from '../blogs-module/blogs-retreive-all/blogs-retreive-all.component';
import { LoginComponent } from '../auth-module/login/login.component';
import { LogoutComponent } from '../auth-module/logout/logout.component';
import { ForgotPasswordComponent } from '../auth-module/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from '../auth-module/reset-password/reset-password.component';
import { SignUpComponent } from '../auth-module/sign-up/sign-up.component';
import { RetrieveBloggersComponent } from '../auth-module/retrieve-bloggers/retrieve-bloggers.component';
import { ScorecardViewComponent } from '../archives-module/scorecard-view/scorecard-view.component';
import { TeamViewComponent } from '../teams-module/team-view/team-view.component';
import { PlayerViewComponent } from '../players-module/player-view/player-view.component';
import { SchedulesRetrieveComponent } from '../schedules-module/schedules-retrieve/schedules-retrieve.component';
import { SchedulesCreateComponent } from '../schedules-module/schedules-create/schedules-create.component';
import { SchedulesUpdateComponent } from '../schedules-module/schedules-update/schedules-update.component';
import { StadiumViewComponent } from '../stadiums-module/stadium-view/stadium-view.component';
import { BlogRetrieveFieldComponent } from '../blogs-module/blog-retrieve-field/blog-retrieve-field.component';
import { BlogViewComponent } from '../blogs-module/blog-view/blog-view.component';
import { ScheduleViewComponent } from '../schedules-module/schedule-view/schedule-view.component';
import { AuthGuard } from '../cricket-guards/auth-guard.service';


const routes: Routes = [
  {
    path: '',
    component: ArchivesRetrieveComponent,
    outlet: 'archives'
  },
  {
    path: '',
    component: BlogsRetreiveAllComponent,
    outlet: 'blogs'
  },
  {
    path: '',
    component: SchedulesRetrieveComponent,
    outlet: 'schedules'
  },
  {
    path: 'scorecard-view',
    component: ScorecardViewComponent,
    outlet: 'archives'
  },
  {
    path: 'team-view',
    component: TeamViewComponent,
    outlet: 'teams'
  },
  {
    path: 'all-teams-view',
    component: TeamsRetrieveAllComponent,
    outlet: 'teams'
  },
  {
    path: 'update-team',
    component: TeamsUpdateComponent,
    outlet: 'teams'
  },
  {
    path: 'find-teams',
    component: TeamsRetrieveFieldComponent,
    outlet: 'teams'
  },
  {
    path: 'player-view',
    component: PlayerViewComponent,
    outlet: 'players'
  },
  {
    path: 'all-players-view',
    component: PlayersRetrieveAllComponent,
    outlet: 'players'
  },
  {
    path: 'update-player',
    component: PlayersUpdateComponent,
    outlet: 'players'
  },
  {
    path: 'find-players',
    component: PlayersRetrieveFieldComponent,
    outlet: 'players'
  },
  {
    path: 'stadium-view',
    component: StadiumViewComponent,
    outlet: 'stadiums'
  },
  {
    path: 'all-stadiums-view',
    component: StadiumsRetrieveAllComponent,
    outlet: 'stadiums'
  },
  {
    path: 'update-stadium',
    component: StadiumsUpdateComponent,
    outlet: 'stadiums'
  },
  {
    path: 'find-stadiums',
    component: StadiumsRetrieveFieldComponent,
    outlet: 'stadiums'
  },
  {
    path: 'blog-view',
    component: BlogViewComponent,
    outlet: 'blogs'
  },
  {
    path: 'find-blogs',
    component: BlogRetrieveFieldComponent,
    outlet: 'blogs'
  },
  {
    path: 'schedule-view',
    component: ScheduleViewComponent,
    outlet: 'schedules',
    // canActivate: [RoleGuard]
  },
  {
    path: 'schedule-update',
    component: SchedulesUpdateComponent,
    outlet: 'schedules'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CricketRoutingModule { }
