import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotAuthorizedComponent } from './not-authorized/not-authorized.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import {MatCard, MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {MatInput, MatInputModule} from '@angular/material/input';
import {MatButton, MatButtonModule, MatIconButton} from '@angular/material/button';
import {HttpClientModule, provideHttpClient, withInterceptors} from '@angular/common/http';
import {MatToolbar, MatToolbarModule} from '@angular/material/toolbar';
import {MatMenu, MatMenuModule, MatMenuTrigger} from '@angular/material/menu';
import { AdminTemplateComponent } from './admin-template/admin-template.component';
import { ClientsComponent } from './pages/clients/clients.component';
import { CreditsComponent } from './pages/credits/credits.component';
import { RemboursementsComponent } from './pages/remboursements/remboursements.component';
import {MatTableModule} from '@angular/material/table';
import {appHttpInterceptor} from './interceptors/app-http.interceptor';
@NgModule({
  declarations: [
    AppComponent,
    NotAuthorizedComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    AdminTemplateComponent,
    ClientsComponent,
    CreditsComponent,
    RemboursementsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule,
    MatCardModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatIconModule,
    MatInputModule,
    MatIconButton,
    MatButtonModule,
    MatToolbarModule,
    MatMenuTrigger,
    MatMenuModule,
    FormsModule
  ],
  providers: [
    provideHttpClient(withInterceptors([appHttpInterceptor])),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
