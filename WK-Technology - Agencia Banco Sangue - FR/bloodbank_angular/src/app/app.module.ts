import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeadersComponent } from './components/template/headers/headers.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component'
import { MatIconModule } from '@angular/material/icon'
import {MatSnackBarModule} from '@angular/material/snack-bar';

import { MatSidenavModule } from '@angular/material/sidenav'
import { MatCardModule } from '@angular/material/card'
import { MatListModule } from '@angular/material/list';
import { HomeComponent } from './views/home/home.component';
import { DonatorsComponent } from './views/donators/donators.component';
import { InfoComponent } from './views/info/info.component'
import { HttpClientModule } from '@angular/common/http';

import { ChartsModule } from 'ng2-charts';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { LayoutModule } from '@angular/cdk/layout';




@NgModule({
  declarations: [
    AppComponent,
    HeadersComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    DonatorsComponent,
    InfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    HttpClientModule,
    MatIconModule,
    MatSnackBarModule,
    ChartsModule,
    MatGridListModule,
    MatMenuModule,
    MatButtonModule,
    LayoutModule,
    MatProgressSpinnerModule
  ],
  providers: [NavComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
