import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent {
  @Input() isActive: boolean = false;
  @Input() msg: string = "Lorem ipsum dolor sit!";
  @Output() onDismiss = new EventEmitter<boolean>()
  onDismissClick(){
    this.onDismiss.emit()
  }
}
