import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatBadgeModule } from '@angular/material/badge';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { LayoutService } from '../../../core/services/layout';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    MatBadgeModule,
    MatInputModule,
    MatFormFieldModule
  ],
  templateUrl: './header.html',
  styleUrls: ['./header.scss']
})
export class HeaderComponent {

  constructor(private layoutService: LayoutService){}

  notificationCount = 3;

  currentUser = {
    name: 'Harpreet Kaur'
  };

  toggleSidebar(){

this.layoutService.toggleSidebar();

}

  logout(): void {
    console.log('Logout Clicked');
  }

}