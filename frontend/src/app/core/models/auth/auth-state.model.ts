import { UserResponse } from './user-response.model';

export interface AuthState {

    /**
     * Indicates whether the user is authenticated.
     */
    isAuthenticated: boolean;

    /**
     * JWT Access Token
     */
    accessToken: string | null;

    /**
     * JWT Refresh Token
     */
    refreshToken: string | null;

    /**
     * Logged-in User Information
     */
    user: UserResponse | null;

}