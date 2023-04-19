import { Component } from '@angular/core';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent {
  imgUrl: string = '/assets/images/recipe.svg';
  categories: string[] = ['dessert', 'italian', 'mexican', 'spicy'];
  setImageUrl(evt: Event) {
    const value = (evt.target as HTMLInputElement).value;
    if (value === '') {
      this.imgUrl = '/assets/images/recipe.svg';
      return;
    }
    this.imgUrl = value;
  }
  createCategory(evt: Event) {
    const inputCategory = evt.target as HTMLInputElement;
    if (this.categories.includes(inputCategory.value)) {
      return;
    }
    this.categories.push(inputCategory.value);
    inputCategory.value = '';
  }
  selectCategory(evt: Event) {
    evt.stopPropagation();
    evt.preventDefault();
    const elem = evt.target as HTMLAnchorElement;
    document.querySelectorAll('.category').forEach((el) => {
      el.classList.remove('selected');
    });
    elem.classList.add('selected');
    // elem.getAttribute('data-category')
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
