import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListClientComponent } from './list-client/list-client.component';
import { ListTypeDocumentComponent } from './list-type-document/list-type-document.component';
import { AddClientComponent } from './add-client/add-client.component';


const routes: Routes = [
  
  { path: 'list-client', component: ListClientComponent },
  { path: 'list-type-document', component: ListTypeDocumentComponent},
  { path: 'add-client', component: AddClientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
