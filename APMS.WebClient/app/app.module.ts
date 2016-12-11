import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent }  from './app.component';
import { MapsComponent } from './maps/maps.component';
import { MenuComponent } from './menu/menu.component';
import { LocationService } from './menu/location.service';
import { HttpModule } from '@angular/http';
@NgModule({
  imports: [ 
  BrowserModule,
  HttpModule,
  FormsModule
  ],
  declarations: [ 
    AppComponent,
    MapsComponent,
    MenuComponent
  ],
  bootstrap:    [ AppComponent ],
  providers: [
    LocationService
  ]
})
export class AppModule { }
