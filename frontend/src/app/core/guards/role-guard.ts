import { inject } from '@angular/core';

import {
    ActivatedRouteSnapshot,
    CanActivateFn,
    Router,
    RouterStateSnapshot
} from '@angular/router';

import { AuthService } from '../services/auth';

import { TokenService } from '../services/token';

import { Role } from '../enums/role.enum';

export const roleGuard: CanActivateFn = (

    route: ActivatedRouteSnapshot,

    state: RouterStateSnapshot

) => {

    const authService = inject(AuthService);

    const tokenService = inject(TokenService);

    const router = inject(Router);

    const token = authService.getAccessToken();

    /**
     * User not logged in
     */

    if (!token) {

        return router.createUrlTree(['/login']);

    }

    /**
     * Token expired
     */

    if (tokenService.isTokenExpired(token)) {

        authService.clearSession();

        return router.createUrlTree(['/login']);

    }

    /**
     * Required Roles
     */

    const requiredRoles =

        route.data['roles'] as Role[];

    /**
     * Route doesn't require role
     */

    if (

        !requiredRoles ||

        requiredRoles.length === 0

    ) {

        return true;

    }

    /**
     * User Role
     */

    const userRole =

        tokenService.getRole(token);

    /**
     * User role missing
     */

    if (!userRole) {

        return router.createUrlTree(['/unauthorized']);

    }

    /**
     * Check Authorization
     */

    const hasAccess =

        requiredRoles.includes(

            userRole as Role

        );

    if (!hasAccess) {

        return router.createUrlTree(['/unauthorized']);

    }

    return true;

};