import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DataService } from 'src/app/services/data.service';
import { category } from 'src/app/types/dataTypes';
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
  providers: [DataService],
})
export class CreateComponent implements OnInit {
  constructor(private dataService: DataService) {}
  imgUrl: string = '/assets/images/recipe.svg';
  categories: any = [];
  menus: any = [
    { menuId: '21006ce8-4b5b-4de5-b9d2-62155c900f4a', menuName: 'breakfast' },
    { menuId: '588c23b7-e428-4146-8a71-d5603cdc51fd', menuName: 'lunch' },
    { menuId: 'a4e1355a-9ed9-4b0d-8ab8-6b3aedc42309', menuName: 'snack' },
    { menuId: 'b42ed243-99ef-4e91-9050-2c8cbd092052', menuName: 'dinner' },
  ];
  dishForm = new FormGroup({
    dishName: new FormControl('', [Validators.required]),
    dishDesc: new FormControl('', [Validators.required]),
    dishPrice: new FormControl(0, [Validators.required, Validators.min(0)]),
    categoryId: new FormControl('', [Validators.required]),
    menuId: new FormControl('', [Validators.required]),
    dishImage: new FormControl('', [Validators.required]),
    dishNature: new FormControl('veg', [Validators.required]),
  });
  ngOnInit(): void {
    this.fetchCategories();
  }
  fetchCategories() {
    this.dataService.getCategories().subscribe((res: any) => {
      if (res.msg === undefined) {
        return;
      }
      this.categories = res.categories.reduce(
        (categs: any, category: category) => {
          categs.push({
            categoryId: category.categoryId,
            categoryName: category.categoryName,
          });
          return categs;
        },
        []
      );
    });
  }
  setImageUrl(evt: Event) {
    const value = (evt.target as HTMLInputElement).value;
    if (value === '') {
      this.imgUrl = '/assets/images/recipe.svg';
      return;
    }
    this.imgUrl = value;
  }
  selectMenu(evt: Event) {
    evt.stopPropagation();
    evt.preventDefault();
    const elem = evt.target as HTMLAnchorElement;
    if (elem.classList.contains('selected')) {
      elem.classList.remove('selected');
      this.dishForm.controls['menuId'].setValue('');
      return;
    }
    document.querySelectorAll('.menu').forEach((el) => {
      el.classList.remove('selected');
    });
    elem.classList.add('selected');
    this.dishForm.controls['menuId'].setValue(elem.getAttribute('data-menu'));
  }
  selectCategory(evt: Event) {
    evt.stopPropagation();
    evt.preventDefault();
    const elem = evt.target as HTMLAnchorElement;
    if (elem.classList.contains('selected')) {
      elem.classList.remove('selected');
      this.dishForm.controls['categoryId'].setValue('');
      return;
    }
    document.querySelectorAll('.category').forEach((el) => {
      el.classList.remove('selected');
    });
    elem.classList.add('selected');
    this.dishForm.controls['categoryId'].setValue(
      elem.getAttribute('data-category')
    );

    // elem.getAttribute('data-category')
  }
  addDish() {
    if (this.dishForm.valid) {
      this.dataService
        .addDish(
          this.dishForm.value as {
            dishName: string;
            dishDesc: string;
            dishPrice: number;
            categoryId: string;
            dishImage: string;
            dishNature: string;
            menuId: string;
          }
        )
        .subscribe((res: any) => {
          if (res.msg === undefined) {
            return;
          }
          this.dishForm.reset();
          document
            .querySelectorAll('.category')
            .forEach((el) => el.classList.remove('selected'));
          document
            .querySelectorAll('.menu')
            .forEach((el) => el.classList.remove('selected'));
            this.imgUrl = "/assets/images/recipe.svg"
          // Todo: Add alert
          console.log(res.msg);
        });
    }
  }
}
