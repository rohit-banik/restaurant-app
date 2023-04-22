import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { category } from 'src/app/types/dataTypes';

@Component({
  selector: 'app-menuview',
  templateUrl: './menuview.component.html',
  styleUrls: ['./menuview.component.css'],
  providers: [DataService],
})
export class MenuviewComponent implements OnInit {
  dishes: any = [];
  id: string = '';
  categories: category[] = [];
  currentMenu: any = {
    name: 'Lorem Ipsum',
    desc: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Amet, quaerat illo quia hic voluptates est cum quibusdam commodi? Ducimus velit sit soluta ullam nobis corporis vel omnis eaque. Fugiat, fuga.',
  };
  constructor(
    private dataService: DataService,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.fetchCategories();
    this.route.params.subscribe((param) => {
      this.id = param['id'];
    });
    this.fetchDishes();
    this.currentMenu.name = window.history.state.name;
    this.currentMenu.desc = window.history.state.desc;
  }
  fetchCategories() {
    this.dataService.getCategories().subscribe((res: any) => {
      if (res.msg === undefined) {
        return;
      }
      this.categories = res.categories;
    });
  }
  fetchDishes() {
    this.dataService.getDishesByMenuId(this.id).subscribe((res: any) => {
      if (res.msg === undefined) {
        return;
      }
      this.dishes = res.dishes;
    });
  }
  getCategoryName(id: string): string {
    return this.categories.filter(
      (category: category) => category.categoryId === id
    )[0].categoryName;
  }
}
