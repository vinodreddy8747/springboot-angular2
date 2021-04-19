import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// import Http module
import { HttpModule} from '@angular/http';

// import ReactiveFormsModule for reactive form
import { ReactiveFormsModule } from '@angular/forms';

// import module for Routing.
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { AdminService } from './services/admin.service';
import { ProfileComponent } from './profile/profile.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { HttpClientModule } from '@angular/common/http';
import { AddEmployeeComponent } from './add-employee/add-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    ProfileComponent,
    NavbarComponent,
    ListEmployeeComponent,
    AddEmployeeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path : '',
        component : HomeComponent	
      },
      {
        path : 'login',
        component : LoginComponent	
      },
      {
        path : 'signup',
        component : SignupComponent	
      },
      {
        path : 'profile/:adminId',
        component : ProfileComponent
      },
      {
        path : 'employee/list',
        component : ListEmployeeComponent
      },
      {
        path : 'employee/add',
        component : AddEmployeeComponent
      }
    ])

  ],
  providers: [
    AdminService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
