import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddComponent } from './add/add.component';
import { ListComponent } from './list/list.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ListByCountryComponent } from './list-by-country/list-by-country.component';
import { ListByNameComponent } from './list-by-name/list-by-name.component';
import { SearchByIDComponent } from './search-by-id/search-by-id.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddComponent,
    ListComponent,
    ListByCountryComponent,
    ListByNameComponent,
    SearchByIDComponent
  ],
  imports: [
    BrowserModule, FormsModule, NaviRoutingModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
