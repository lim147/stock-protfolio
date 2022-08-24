import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainpageComponent } from './mainpage/mainpage.component';
import { SearchpageComponent } from './searchpage/searchpage.component';
import { TradingpageComponent } from './tradingpage/tradingpage.component';

const routes: Routes = [
  { path: '', component: MainpageComponent },
  { path: 'search', component: SearchpageComponent},
  { path: 'trading', component: TradingpageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
