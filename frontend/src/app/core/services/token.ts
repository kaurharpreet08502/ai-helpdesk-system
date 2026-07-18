import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';

import { JwtPayload } from '../models/auth/jwt-payload.model';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() {}

  // ==========================================================
  // Decode JWT
  // ==========================================================

  decodeToken(token: string): JwtPayload | null {

    try {

      return jwtDecode<JwtPayload>(token);

    } catch (error) {

      console.error('Invalid JWT Token', error);

      return null;

    }

  }

  // ==========================================================
  // Token Validation
  // ==========================================================

  isTokenValid(token: string | null): boolean {

    if (!token) {

      return false;

    }

    return !this.isTokenExpired(token);

  }

  // ==========================================================
  // Expiry Check
  // ==========================================================

  isTokenExpired(token: string): boolean {

    const payload = this.decodeToken(token);

    if (!payload) {

      return true;

    }

    const currentTime = Math.floor(Date.now() / 1000);

    return payload.exp <= currentTime;

  }

  // ==========================================================
  // Expiration Date
  // ==========================================================

  getExpirationDate(token: string): Date | null {

    const payload = this.decodeToken(token);

    if (!payload) {

      return null;

    }

    return new Date(payload.exp * 1000);

  }

  // ==========================================================
  // User Information
  // ==========================================================

  getUserId(token: string): number | null {

    const payload = this.decodeToken(token);

    return payload?.userId ?? null;

  }

  getEmail(token: string): string | null {

    const payload = this.decodeToken(token);

    return payload?.email ?? null;

  }

  getRole(token: string): string | null {

    const payload = this.decodeToken(token);

    return payload?.role ?? null;

  }

  getUsername(token: string): string | null {

    const payload = this.decodeToken(token);

    return payload?.sub ?? null;

  }

  // ==========================================================
  // Time Remaining
  // ==========================================================

  getRemainingTime(token: string): number {

    const payload = this.decodeToken(token);

    if (!payload) {

      return 0;

    }

    const currentTime = Math.floor(Date.now() / 1000);

    return Math.max(payload.exp - currentTime, 0);

  }

  // ==========================================================
  // Utility Methods
  // ==========================================================

  willExpireSoon(
    token: string,
    thresholdInSeconds: number = 300
  ): boolean {

    return this.getRemainingTime(token) <= thresholdInSeconds;

  }

  hasRole(
    token: string,
    role: string
  ): boolean {

    return this.getRole(token) === role;

  }

  hasAnyRole(
    token: string,
    roles: string[]
  ): boolean {

    const userRole = this.getRole(token);

    return !!userRole && roles.includes(userRole);

  }

}