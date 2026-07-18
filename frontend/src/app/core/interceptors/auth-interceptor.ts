import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest
} from '@angular/common/http';

import { Injectable } from '@angular/core';

import {
  Observable,
  throwError
} from 'rxjs';

import {
  catchError,
  switchMap
} from 'rxjs/operators';

import { AuthService } from '../services/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private authService: AuthService
  ) {}

  intercept(

    request: HttpRequest<any>,

    next: HttpHandler

  ): Observable<HttpEvent<any>> {

    if (this.shouldSkip(request.url)) {

      return next.handle(request);

    }

    const token =
      this.authService.getAccessToken();

    let authRequest = request;

    if (token) {

      authRequest = request.clone({

        setHeaders: {

          Authorization: `Bearer ${token}`

        }

      });

    }

    return next.handle(authRequest).pipe(

      catchError((error: HttpErrorResponse) => {

        if (

          error.status === 401 &&

          !this.shouldSkip(request.url)

        ) {

          return this.handle401Error(

            authRequest,

            next

          );

        }

        return throwError(() => error);

      })

    );

  }

  /**
   * Refresh Token Logic
   */
  private handle401Error(

    request: HttpRequest<any>,

    next: HttpHandler

  ): Observable<HttpEvent<any>> {

    return this.authService.refreshToken().pipe(

      switchMap(() => {

        const newToken =
          this.authService.getAccessToken();

        const clonedRequest =
          request.clone({

            setHeaders: {

              Authorization:
                `Bearer ${newToken}`

            }

          });

        return next.handle(clonedRequest);

      }),

      catchError(error => {

        this.authService.clearSession();

        return throwError(() => error);

      })

    );

  }

  /**
   * Skip Authentication APIs
   */
  private shouldSkip(
    url: string
  ): boolean {

    return (

      url.includes('/auth/login')

      ||

      url.includes('/auth/refresh-token')

      ||

      url.includes('/auth/forgot-password')

      ||

      url.includes('/auth/reset-password')

    );

  }

}