import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

import { AuthState } from '../models/auth/auth-state.model';
import { UserResponse } from '../models/auth/user-response.model';

@Injectable({
  providedIn: 'root'
})
export class AuthStateService {

  /**
   * Initial Authentication State
   */
  private readonly initialState: AuthState = {
    isAuthenticated: false,
    user: null,
    accessToken: null,
    refreshToken: null
  };

  /**
   * Authentication State
   */
  private authStateSubject =
    new BehaviorSubject<AuthState>(this.initialState);

  /**
   * Observable for Components
   */
  authState$: Observable<AuthState> =
    this.authStateSubject.asObservable();

  constructor() { }

  // =====================================================
  // Authentication State
  // =====================================================

  setAuthentication(
    accessToken: string,
    refreshToken: string,
    user: UserResponse
  ): void {

    this.authStateSubject.next({

      isAuthenticated: true,

      accessToken,

      refreshToken,

      user

    });

  }

  getAuthentication(): AuthState {

    return this.authStateSubject.getValue();

  }

  // =====================================================
  // User
  // =====================================================

  setCurrentUser(user: UserResponse): void {

    const state = this.getAuthentication();

    this.authStateSubject.next({

      ...state,

      user

    });

  }

  getCurrentUser(): UserResponse | null {

    return this.getAuthentication().user;

  }

  // =====================================================
  // Tokens
  // =====================================================

  setAccessToken(token: string): void {

    const state = this.getAuthentication();

    this.authStateSubject.next({

      ...state,

      accessToken: token

    });

  }

  getAccessToken(): string | null {

    return this.getAuthentication().accessToken;

  }

  setRefreshToken(token: string): void {

    const state = this.getAuthentication();

    this.authStateSubject.next({

      ...state,

      refreshToken: token

    });

  }

  getRefreshToken(): string | null {

    return this.getAuthentication().refreshToken;

  }

  // =====================================================
  // Authentication Status
  // =====================================================

  isAuthenticated(): boolean {

    return this.getAuthentication().isAuthenticated;

  }

  // =====================================================
  // Logout
  // =====================================================

  clearAuthentication(): void {

    this.authStateSubject.next(this.initialState);

  }

  // =====================================================
  // Utility Methods
  // =====================================================

  hasUser(): boolean {

    return this.getCurrentUser() !== null;

  }

  hasAccessToken(): boolean {

    return !!this.getAccessToken();

  }

  hasRefreshToken(): boolean {

    return !!this.getRefreshToken();

  }

  // =====================================================
  // Update Complete State
  // =====================================================

  updateState(state: AuthState): void {

    this.authStateSubject.next(state);

  }

  // =====================================================
  // Snapshot
  // =====================================================

  getSnapshot(): AuthState {

    return this.authStateSubject.value;

  }

}