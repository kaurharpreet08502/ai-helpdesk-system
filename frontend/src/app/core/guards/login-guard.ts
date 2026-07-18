import { inject } from '@angular/core';

import {
    CanActivateFn,
    Router
} from '@angular/router';

import { AuthService } from '../services/auth';
import { TokenService } from '../services/token';

export const loginGuard: CanActivateFn = () => {

    const authService = inject(AuthService);

    const tokenService = inject(TokenService);

    const router = inject(Router);

    const token = authService.getAccessToken();

    /**
     * No token
     * Allow Login Page
     */

    if (!token) {

        return true;

    }

    /**
     * Expired Token
     * Allow Login Page
     */

    if (tokenService.isTokenExpired(token)) {

        authService.clearSession();

        return true;

    }

    /**
     * Already Logged In
     */

    return router.createUrlTree([
        '/dashboard'
    ]);

};