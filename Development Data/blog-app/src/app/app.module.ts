import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddblogComponent } from './addblog/addblog.component';
import { ListblogComponent } from './listblog/listblog.component';
import { SearchblogComponent } from './searchblog/searchblog.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AddblogComponent,
    ListblogComponent,
    SearchblogComponent
  ],
  imports: [
    BrowserModule,FormsModule, NaviRoutingModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
