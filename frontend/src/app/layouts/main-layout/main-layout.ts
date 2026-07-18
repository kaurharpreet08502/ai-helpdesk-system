import { Component, HostListener } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatSidenavModule } from '@angular/material/sidenav';

import { HeaderComponent } from '../../shared/components/header/header';
import { SidebarComponent } from '../../shared/components/sidebar/sidebar';
import { FooterComponent } from '../../shared/components/footer/footer';
import { LayoutService } from '../../core/services/layout';

@Component({
  selector: 'app-main-layout',
  standalone: true,
  imports: [
    RouterOutlet,
    MatSidenavModule,
    HeaderComponent,
    SidebarComponent,
    FooterComponent
  ],
  templateUrl: './main-layout.html',
  styleUrls: ['./main-layout.scss']
})
export class MainLayoutComponent {

  isMobile = false;

  sidebarOpened = true;

  constructor(private layoutService:LayoutService){

this.layoutService.sidebarState$.subscribe(value=>{

this.sidebarOpened=value;

});

}

  @HostListener('window:resize')
  onResize(): void {
    this.checkScreenSize();
  }

  toggleSidebar(): void {
    this.sidebarOpened = !this.sidebarOpened;
  }

  private checkScreenSize(): void {

    this.isMobile = window.innerWidth < 992;

    if (this.isMobile) {
      this.sidebarOpened = false;
    } else {
      this.sidebarOpened = true;
    }
  }

}