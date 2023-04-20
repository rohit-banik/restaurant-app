import { Component } from '@angular/core';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent {
  categories: string[] = ['dessert', 'italian', 'mexican', 'spicy'];

  createCategory(evt: Event) {
    const inputCategory = evt.target as HTMLInputElement;
    if (this.categories.includes(inputCategory.value)) {
      return;
    }
    this.categories.push(inputCategory.value);
    inputCategory.value = '';
  }
  deleteCategory(evt: Event) {
    evt.stopPropagation();
    evt.preventDefault();
    const linkPar = (evt.currentTarget as HTMLElement).parentElement;
    if (linkPar == null) {
      return;
    }
    const category = linkPar.getAttribute('data-category');
    this.categories = this.categories.filter((categ) => categ !== category);
  }
}
