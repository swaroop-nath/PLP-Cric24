import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { FindComponent } from './find/find.component';
import { ListComponent } from './list/list.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { UpdateComponent } from './update/update.component';
@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    FindComponent,
    ListComponent,
    UpdateComponent
  ],
  imports: [
    FormsModule,NaviRoutingModule, BrowserModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
