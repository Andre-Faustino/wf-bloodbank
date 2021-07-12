import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './views/home/home.component'
import { DonatorsComponent } from './views/donators/donators.component';
import { InfoComponent } from './views/info/info.component'

const routes: Routes = [{
  path : "",
  component: HomeComponent
},{
  path : "donators",
  component: DonatorsComponent
},{
  path : "info",
  component: InfoComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
