import { Injectable } from '@angular/core';

import { STORAGE_KEYS } from '../constants/storage.constants';

import { UserResponse } from '../models/auth/user-response.model';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  // ===========================================================
  // Generic Methods
  // ===========================================================

  setItem(key: string, value: string): void {

    localStorage.setItem(key, value);

  }

  getItem(key: string): string | null {

    return localStorage.getItem(key);

  }

  removeItem(key: string): void {

    localStorage.removeItem(key);

  }

  clear(): void {

    localStorage.clear();

  }

  // ===========================================================
  // Access Token
  // ===========================================================

  saveAccessToken(token: string): void {

    this.setItem(STORAGE_KEYS.ACCESS_TOKEN, token);

  }

  getAccessToken(): string | null {

    return this.getItem(STORAGE_KEYS.ACCESS_TOKEN);

  }

  removeAccessToken(): void {

    this.removeItem(STORAGE_KEYS.ACCESS_TOKEN);

  }

  // ===========================================================
  // Refresh Token
  // ===========================================================

  saveRefreshToken(token: string): void {

    this.setItem(STORAGE_KEYS.REFRESH_TOKEN, token);

  }

  getRefreshToken(): string | null {

    return this.getItem(STORAGE_KEYS.REFRESH_TOKEN);

  }

  removeRefreshToken(): void {

    this.removeItem(STORAGE_KEYS.REFRESH_TOKEN);

  }

  // ===========================================================
  // Current User
  // ===========================================================

  saveCurrentUser(user: UserResponse): void {

    this.setItem(

      STORAGE_KEYS.CURRENT_USER,

      JSON.stringify(user)

    );

  }

  getCurrentUser(): UserResponse | null {

    const user = this.getItem(STORAGE_KEYS.CURRENT_USER);

    return user ? JSON.parse(user) : null;

  }

  removeCurrentUser(): void {

    this.removeItem(STORAGE_KEYS.CURRENT_USER);

  }

  // ===========================================================
  // Remember Me
  // ===========================================================

  saveRememberMe(value: boolean): void {

    this.setItem(

      STORAGE_KEYS.REMEMBER_ME,

      JSON.stringify(value)

    );

  }

  getRememberMe(): boolean {

    const remember = this.getItem(STORAGE_KEYS.REMEMBER_ME);

    return remember ? JSON.parse(remember) : false;

  }

  removeRememberMe(): void {

    this.removeItem(STORAGE_KEYS.REMEMBER_ME);

  }

  // ===========================================================
  // Authentication Helpers
  // ===========================================================

  isLoggedIn(): boolean {

    return !!this.getAccessToken();

  }

  hasRefreshToken(): boolean {

    return !!this.getRefreshToken();

  }

  clearAuthentication(): void {

    this.removeAccessToken();

    this.removeRefreshToken();

    this.removeCurrentUser();

    this.removeRememberMe();

  }

}