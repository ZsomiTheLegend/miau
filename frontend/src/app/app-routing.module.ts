import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TermekekComponent } from './components/termekek/termekek.component';
import { FelvitelComponent } from './components/felvitel/felvitel.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'termekek', component: TermekekComponent },
  { path: 'fooldal', component: FelvitelComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }