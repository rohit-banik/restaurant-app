import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductCardComponent } from './components/card/productcard.component';
import { DishesComponent } from './views/dishes/dishes.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AlertComponent } from './components/alert/alert.component';
import { PromptComponent } from './components/prompt/prompt.component';
import { CreateComponent } from './views/create/create.component';
import { EditComponent } from './views/edit/edit.component';
import { HomeComponent } from './views/home/home.component';
import { CreateCategoryComponent } from './views/create-category/create-category.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { MenuviewComponent } from './views/menuview/menuview.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductCardComponent,
    DishesComponent,
    NavbarComponent,
    AlertComponent,
    PromptComponent,
    CreateComponent,
    EditComponent,
    HomeComponent,
    CreateCategoryComponent,
    MenuviewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
