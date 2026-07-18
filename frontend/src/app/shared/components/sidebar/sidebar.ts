import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';

import { NAVIGATION } from '../../../core/constants/navigation.constants';
import { NavigationItem } from '../../../core/models/navigation-item.model';
import { UserRole } from '../../../core/enums/user-role.enum';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    MatListModule,
    MatIconModule
  ],
  templateUrl: './sidebar.html',
  styleUrls: ['./sidebar.scss']
})
export class SidebarComponent {

  navigationItems: NavigationItem[] = NAVIGATION;

  currentRole = UserRole.ADMIN;

  get filteredNavigation(): NavigationItem[] {

    return this.navigationItems.filter(item =>
      item.roles.includes(this.currentRole)
    );

  }

}