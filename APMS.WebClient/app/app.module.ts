import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';


import { AppComponent }  from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LocationService } from './menu/location.service';
import { NodeService } from './node-service';
import { MessageService } from './message-service'
import { AnalyzeComponent } from './analyze/analyze.component';
import { ManageComponent } from './manage/manage.component';
import { InputComponent } from './input/input.component';

const appRoutes: Routes = [
  { path: 'analyze', component: AnalyzeComponent },
  { path: 'manage', component: ManageComponent },
  { path: 'input', component: InputComponent },
  { path: 'map', component: MenuComponent },
  { path: '', redirectTo:'/map', pathMatch:'full'}
];
@NgModule({
  imports: [ 
  BrowserModule,
  HttpModule,
  FormsModule,
  RouterModule.forRoot(appRoutes)
  ],
  declarations: [ 
    AppComponent,
    MenuComponent,
    InputComponent,
    AnalyzeComponent,
    ManageComponent
  ],
  bootstrap:    [ AppComponent ],
  providers: [
    LocationService,
    NodeService,
    MessageService
  ]
})
export class AppModule { }
