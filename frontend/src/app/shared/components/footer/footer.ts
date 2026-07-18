import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './footer.html',
  styleUrls: ['./footer.scss']
})
export class FooterComponent {

  readonly version = '1.0.0';

  readonly environment = 'Development';

  readonly backendStatus = 'Offline';

  readonly databaseStatus = 'Offline';

  readonly aiStatus = 'Offline';

  readonly currentYear = new Date().getFullYear();

}