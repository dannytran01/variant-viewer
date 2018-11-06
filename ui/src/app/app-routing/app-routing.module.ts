import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GeneDetailsComponent} from '../gene-details/gene-details.component';

const appRoutes: Routes = [
  {
    path: 'gene',
    component: GeneDetailsComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
