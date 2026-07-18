import { UserResponse } from '../models/auth/user-response.model';

export interface LoginResponse {

  accessToken: string;

  refreshToken: string;

  tokenType: string;

  expiresIn: number;

  user: UserResponse;

}