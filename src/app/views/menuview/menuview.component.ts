import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { category, dish } from 'src/app/types/dataTypes';

@Component({
  selector: 'app-menuview',
  templateUrl: './menuview.component.html',
  styleUrls: ['./menuview.component.css'],
  providers: [DataService],
})
export class MenuviewComponent implements OnInit {
  dishes: any = [];
  filteredDishes: any = [];
  alertMsg: string = '';
  alertState: boolean = false;
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
    this.currentMenu.name = window.history.state.name;
    this.currentMenu.desc = window.history.state.desc;
    this.fetchDishes();
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
      this.filteredDishes = [...this.dishes];
    });
  }
  getCategoryName(id: string): string {
    return this.categories.filter(
      (category: category) => category.categoryId === id
    )[0].categoryName;
  }
  onDismissHandler() {
    this.alertState = false;
    this.alertMsg = '';
  }
  onSearch(evt: Event) {
    const { value }: { value: string } = evt.target as HTMLInputElement;
    this.filteredDishes = this.dishes.filter((dish: dish) => {
      return (
        dish.dishName.toLowerCase().includes(value) || dish.dishNature === value || dish.dishDesc.toLowerCase().includes(value)
      );
    });
  }
  onDeleteHandler(dishId: string) {
    this.dataService.delteDishById(dishId).subscribe((res: any) => {
      if (res.msg === undefined) {
        return;
      }
      this.alertMsg = res.msg;
      this.alertState = true;
      this.fetchDishes();
    });
  }
}
