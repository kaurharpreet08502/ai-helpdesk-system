import { ApplicationConfig, provideAppInitializer } from '@angular/core';
import { provideRouter } from '@angular/router';

import {
  provideHttpClient,
  withInterceptorsFromDi,
  HTTP_INTERCEPTORS
} from '@angular/common/http';

import { provideAnimations } from '@angular/platform-browser/animations';

import { routes } from './app.routes';

import { AuthInterceptor } from './core/interceptors/auth-interceptor';

import { initializeAuthentication } from './core/initializers/authentication.initializer';

export const appConfig: ApplicationConfig = {

  providers: [

    provideRouter(routes),

    provideAnimations(),

    provideHttpClient(
      withInterceptorsFromDi()
    ),

    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },

    provideAppInitializer(
      initializeAuthentication
    )

  ]

};