import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-productcard',
  templateUrl: './productcard.component.html',
  styleUrls: ['./productcard.component.css'],
})
export class ProductCardComponent {
  @Input() dishName: string = '';
  @Input() dishDesc: string = '';
  @Input() dishId: string = '';
  @Input() dishPrice: number = 0.00;
  @Input() dishImage: string = '/assets/images/img1.jpg'
  @Input() dishNature: string = "";
  @Input() categoryName: string = "french"
  @Output() onDelete = new EventEmitter<string>();
  deleteHandler(){
    console.log(this.dishId);
    this.onDelete.emit(this.dishId);
  }
}
// https://yuka.io/wp-content/uploads/10-Lunch-big.png