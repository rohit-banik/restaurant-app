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
  selectCategory(evt: Event) {
    evt.stopPropagation();
    evt.preventDefault();
    const elem = evt.target as HTMLAnchorElement;
    if (elem.classList.contains('selected')) {
      elem.classList.remove('selected');
      return;
    }
    document.querySelectorAll('.category').forEach((el) => {
      el.classList.remove('selected');
    });
    elem.classList.add('selected');
    // elem.getAttribute('data-category')
  }
 
}
