import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { ListComponent } from './list/list.component';
import { FindComponent } from './find/find.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UpdateComponent } from './update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    ListComponent,
    FindComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule, FormsModule, NaviRoutingModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
