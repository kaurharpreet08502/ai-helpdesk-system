import { inject } from '@angular/core';

import {
    CanActivateFn,
    Router
} from '@angular/router';

import { AuthService } from '../services/auth';

import { TokenService } from '../services/token';

export const authGuard: CanActivateFn = () => {

    const authService = inject(AuthService);

    const tokenService = inject(TokenService);

    const router = inject(Router);

    const token = authService.getAccessToken();

    /**
     * No Token
     */
    if (!token) {

        return router.createUrlTree(['/login']);

    }

    /**
     * Token Expired
     */
    if (tokenService.isTokenExpired(token)) {

        authService.clearSession();

        return router.createUrlTree(['/login']);

    }

    /**
     * Logged In
     */
    return true;

};