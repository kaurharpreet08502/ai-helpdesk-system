import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

import {
  Observable,
  throwError
} from 'rxjs';

import {
  tap,
  catchError
} from 'rxjs/operators';
import { of, } from 'rxjs';

import { API_CONFIG } from '../../core/constants/api.constants';

import { StorageService } from '../../core/services/storage';

import { AuthStateService } from '../../core/services/auth-state';
import { TokenService } from '../../core/services/token';


import { LoginRequest } from '../models/login-request.model';

import { LoginResponse } from '../models/login-response.model';
import { UserResponse } from '../models/auth/user-response.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(

    private http: HttpClient,

    private router: Router,

    private storageService: StorageService,

    private authStateService: AuthStateService,
    private tokenService: TokenService

  ) { }

  // ============================================================
  // Login
  // ============================================================

  login(
    request: LoginRequest
  ): Observable<LoginResponse> {

    return this.http.post<LoginResponse>(

      API_CONFIG.BASE_URL +

      API_CONFIG.AUTH.LOGIN,

      request

    ).pipe(

      tap((response: LoginResponse) => {

        this.handleLoginSuccess(response);

      }),

      catchError((error) =>

        this.handleError(error)

      )

    );

  }

  // ============================================================
  // Login Success
  // ============================================================

  private handleLoginSuccess(
    response: LoginResponse
  ): void {

    this.storageService.saveAccessToken(

      response.accessToken

    );

    this.storageService.saveRefreshToken(

      response.refreshToken

    );

    this.storageService.saveCurrentUser(

      response.user

    );

    this.authStateService.setAuthentication(

      response.accessToken,

      response.refreshToken,

      response.user

    );

    this.router.navigate([
      '/dashboard'
    ]);

  }
  private clearAuthentication(): void {

  this.storageService.clearAuthentication();

  this.authStateService.clearAuthentication();

  this.router.navigate([
    '/login'
  ]);

}

  // ============================================================
  // Error Handler
  // ============================================================


  // ============================================================
// Logout
// ============================================================

logout(): Observable<void> {

  return this.http.post<void>(

    API_CONFIG.BASE_URL +

    API_CONFIG.AUTH.LOGOUT,

    {}

  ).pipe(

    tap(() => {

      this.clearAuthentication();

    }),

    catchError((error) => {

      /*
       * Even if backend logout fails,
       * clear client session.
       */

      this.clearAuthentication();

      return throwError(() => error);

    })

  );

}

// ============================================================
// Refresh Token
// ============================================================

refreshToken(): Observable<LoginResponse> {

  const refreshToken =
    this.storageService.getRefreshToken();

  return this.http.post<LoginResponse>(

    API_CONFIG.BASE_URL +

    API_CONFIG.AUTH.REFRESH_TOKEN,

    {

      refreshToken

    }

  ).pipe(

    tap((response: LoginResponse) => {

      this.storageService.saveAccessToken(

        response.accessToken

      );

      this.storageService.saveRefreshToken(

        response.refreshToken

      );

      this.authStateService.setAuthentication(

        response.accessToken,

        response.refreshToken,

        response.user

      );

    }),

    catchError((error) =>

      this.handleError(error)

    )

  );

}

// ============================================================
// Forgot Password
// ============================================================

forgotPassword(
  email: string
): Observable<void> {

  return this.http.post<void>(

    API_CONFIG.BASE_URL +

    API_CONFIG.AUTH.FORGOT_PASSWORD,

    {

      email

    }

  ).pipe(

    catchError((error) =>

      this.handleError(error)

    )

  );

}

// ============================================================
// Reset Password
// ============================================================

resetPassword(

  token: string,

  newPassword: string

): Observable<void> {

  return this.http.post<void>(

    API_CONFIG.BASE_URL +

    API_CONFIG.AUTH.RESET_PASSWORD,

    {

      token,

      newPassword

    }

  ).pipe(

    catchError((error) =>

      this.handleError(error)

    )

  );

}

// ============================================================
// Current Logged In User
// ============================================================

getCurrentUser(): Observable<UserResponse> {

  return this.http.get<UserResponse>(

    API_CONFIG.BASE_URL +

    API_CONFIG.AUTH.CURRENT_USER

  ).pipe(

    tap((user: UserResponse) => {

      this.storageService.saveCurrentUser(

        user

      );

      this.authStateService.setCurrentUser(

        user

      );

    }),

    catchError((error) =>

      this.handleError(error)

    )

  );

}
// ============================================================
// Restore Authentication From Storage
// ============================================================

restoreAuthentication(): void {

    const accessToken =
        this.storageService.getAccessToken();

    const refreshToken =
        this.storageService.getRefreshToken();

    const user =
        this.storageService.getCurrentUser();

    if (

        !accessToken ||

        !refreshToken ||

        !user

    ) {

        return;

    }

    if (

        this.tokenService.isTokenExpired(accessToken)

    ) {

        this.clearSession();

        return;

    }

    this.authStateService.setAuthentication(

        accessToken,

        refreshToken,

        user

    );

}
// ============================================================
// Authentication Status
// ============================================================

isLoggedIn(): boolean {

  return this.storageService.isLoggedIn();

}
// ============================================================
// Current Access Token
// ============================================================

getAccessToken(): string | null {

  return this.storageService.getAccessToken();

}
// ============================================================
// Current Refresh Token
// ============================================================

getRefreshToken(): string | null {

  return this.storageService.getRefreshToken();

}
// ============================================================
// Cached User
// ============================================================

getCurrentUserFromStorage(): UserResponse | null {

  return this.storageService.getCurrentUser();

}
// ============================================================
// Clear Session
// ============================================================

clearSession(): void {

  this.storageService.clearAuthentication();

  this.authStateService.clearAuthentication();

}
// ============================================================
// Centralized Error Handler
// ============================================================

private handleError(

  error: HttpErrorResponse

) {

  let message = 'Something went wrong.';

  switch (error.status) {

    case 0:

      message =
        'Unable to connect to the server.';

      break;

    case 400:

      message =
        'Invalid request.';

      break;

    case 401:

      message =
        'Invalid email or password.';

      break;

    case 403:

      message =
        'Access denied.';

      break;

    case 404:

      message =
        'Requested resource not found.';

      break;

    case 500:

      message =
        'Internal server error.';

      break;

    default:

      message =
        error.error?.message ??
        'Unexpected error occurred.';

  }

  console.error(

    '[AUTH ERROR]',

    message,

    error

  );

  return throwError(

    () => new Error(message)

  );

}
// ============================================================
// Has Active Session
// ============================================================

hasActiveSession(): boolean {

  return (

    this.storageService.isLoggedIn()

    &&

    this.storageService.hasRefreshToken()

  );

}

// ============================================================
// Remember Me
// ============================================================

isRememberMeEnabled(): boolean {

  return this.storageService.getRememberMe();

}
}