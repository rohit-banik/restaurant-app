import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { CreateComponent } from './views/create/create.component';
import { EditComponent } from './views/edit/edit.component';
import { CreateCategoryComponent } from './views/create-category/create-category.component';
import { MenuviewComponent } from './views/menuview/menuview.component';
import { EditCategoryComponent } from './views/edit-category/edit-category.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'add',
    children: [
      { path: '', pathMatch: 'full', redirectTo: 'dish' },
      { path: 'dish', component: CreateComponent },
      { path: 'category', component: CreateCategoryComponent },
    ],
  },
  {
    path: 'edit',
    children: [
      {
        path: 'dish/:id',
        component: EditComponent,
      },
      { path: 'category/:id', component: EditCategoryComponent },
    ],
  },
  { path: 'menu/:id', component: MenuviewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
