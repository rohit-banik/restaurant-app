import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import {category} from 'src/app/types/dataTypes';
import { FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css'],
  providers: [DataService],
})
export class CreateCategoryComponent implements OnInit {
  imgUrl: string = '/assets/images/recipe.svg';
  categories: { categoryId: string; categoryName: string }[] = [];
  alertState: boolean = false;
  alertMsg: string = '';
  constructor(private dataService: DataService) {}
  categoryForm = new FormGroup({
    categoryImage: new FormControl('', [Validators.required]),
    categoryName: new FormControl('', [Validators.required]),
    categoryDesc: new FormControl('', Validators.required),
  });
  ngOnInit(): void {
    this.fetchCategories();
  }
  onDismissHandler(){
    this.alertState = false;
    this.alertMsg = ""
  }
  addUrl() {
    const value = this.categoryForm.controls['categoryImage'].value;
    if (value !== undefined && value !== null) {
      this.imgUrl = value;
    }
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
  createCategory() {
    const value = this.categoryForm.controls['categoryName'].value;
    if (value !== null && value !== undefined) {
      this.categoryForm.controls['categoryName'].setValue(value.toLowerCase());
    }
    if (
      this.categories.some((category: any) => {
        return (
          category.categoryName ===
          this.categoryForm.controls['categoryName'].value
        );
      })
    ) {
      console.log('duplicate categories');
      return;
    }
    if (this.categoryForm.valid) {
      this.dataService
        .addCategory(
          this.categoryForm.value as {
            categoryImage: string;
            categoryName: string;
            categoryDesc: string;
          }
        )
        .subscribe((res: any) => {
          if (res.msg === undefined) {
            return;
          }
          this.fetchCategories();
          this.categoryForm.reset();
          // Todo: Call alert info here
            this.alertMsg = res.msg
            this.alertState = true
        });
    }

    this.categoryForm.controls['categoryName'].setValue('');
  }
  deleteCategory(evt: Event) {
    evt.stopPropagation();
    evt.preventDefault();
    const linkPar = (evt.currentTarget as HTMLElement).parentElement;
    if (linkPar == null) {
      return;
    }
    const category = linkPar.getAttribute('data-category');
    console.log(category);
    // this.categories = this.categories.filter((categ) => categ !== category);
  }
}
