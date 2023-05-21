import { NgModule } from '@angular/core';
import { BrowserModule,  } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PERSON_SERVICE_TOKEN, PERSON_SERVICE_BACKEND_URL } from './person_color/services/person-color-service-if'
import { PersonColorService } from './person_color/services/person-color-service'
import { PersonalDetails } from './person_color/components/personal-details'
import { InfoDialog } from './person_color/components/info-dialog'
import { environment } from '../environments/environment';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { RouterModule } from '@angular/router'
import { HttpClientModule } from '@angular/common/http';
import { MatSortModule } from '@angular/material/sort';
import { MatDialogModule } from "@angular/material/dialog";

@NgModule({
  declarations: [
    AppComponent,
    PersonalDetails,
    InfoDialog
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatTabsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    MatDialogModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
        {path: 'personal-details', component: PersonalDetails}
    ])
  ],
  providers: [
  {
    provide: PERSON_SERVICE_BACKEND_URL,
    useValue: environment.services.backend_rest.url
  },
  {
    provide: PERSON_SERVICE_TOKEN,
    useClass: PersonColorService
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
