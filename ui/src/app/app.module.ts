import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {GeneSearchComponent} from './gene-search/gene-search.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {GeneDetailsComponent} from './gene-details/gene-details.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {RouterModule} from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import {MatProgressBarModule, MatSortModule} from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    GeneSearchComponent,
    GeneDetailsComponent
  ],
  imports: [
    AppRoutingModule,
    RouterModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatInputModule,
    MatFormFieldModule,
    MatTableModule,
    MatSortModule,
    MatProgressBarModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
