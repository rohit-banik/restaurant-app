import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [DataService],
})
export class HomeComponent implements OnInit {
  menus: any = [];
  constructor(private dataService: DataService) {}
  ngOnInit(): void {
    this.fetchMenus();
  }

  fetchMenus() {
    this.dataService.getMenus().subscribe((res: any) => {
      if (res.msg === undefined) {
        return;
      }
      this.menus = res.menus;
    });
  }
}
