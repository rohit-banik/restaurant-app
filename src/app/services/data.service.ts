import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  constructor(private client: HttpClient) {}
  getCategories() {
    return this.client.get('http://localhost:8080/api/categories');
  }
  editCategory(id: string, categorydata: any) {
    return this.client.post('http://localhost:8080/api/categories/' + id, {});
  }
  addCategory(newCategory: {
    categoryImage: string;
    categoryName: string;
    categoryDesc: string;
  }) {
    return this.client.post(
      'http://localhost:8080/api/categories/',
      newCategory
    );
  }
  addDish(newDish: {
    dishName: string;
    dishDesc: string;
    dishPrice: number;
    categoryId: string;
    dishImage: string;
    dishNature: string;
    menuId: string;
  }) {
    return this.client.post('http://localhost:8080/api/menuitems/', newDish);
  }
  getAllDishes() {
    return this.client.get('http://localhost:8080/api/menuitems/');
  }
  getDishesByMenuId(menuId: string) {
    return this.client.get(
      'http://localhost:8080/api/menuitems/menu/' + menuId
    );
  }
  getMenus() {
    return this.client.get('http://localhost:8080/api/menus');
  }
  getDishById(dishId: string) {
    return this.client.get('http://localhost:8080/api/menuitems/' + dishId);
  }
  editDishById(
    dishId: string,
    editedDish: {
      dishName: string;
      dishDesc: string;
      dishPrice: number;
      categoryId: string;
      dishImage: string;
      dishNature: string;
      menuId: string;
    }
  ) {
    return this.client.put(
      'http://localhost:8080/api/menuitems/update/' + dishId,
      editedDish
    );
  }
  delteDishById(dishId: string) {
    return this.client.delete(
      'http://localhost:8080/api/menuitems/delete/' + dishId
    );
  }
}
