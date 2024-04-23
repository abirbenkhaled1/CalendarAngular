import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CalanderComponent} from "./calander/calander.component";
import {CardsComponent} from "./cards/cards.component";

const routes: Routes = [
  { path: 'calander/:id', component: CalanderComponent },
  { path: '**', component: CardsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
