import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-unauthorized',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    MatButtonModule,
    MatIconModule
  ],
  templateUrl: './unauthorized.component.html',
  styleUrls: ['./unauthorized.component.scss']
})
export class UnauthorizedComponent {

  constructor(private router: Router) {}

  goToDashboard(): void {
    this.router.navigate(['/dashboard']);
  }

  logout(): void {
    this.router.navigate(['/login']);
  }

}