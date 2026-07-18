import { inject } from '@angular/core';
import { AuthService } from '../services/auth';

export function initializeAuthentication(): void {

    const authService = inject(AuthService);

    authService.restoreAuthentication();

}