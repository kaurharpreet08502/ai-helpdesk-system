/**
 * Browser Storage Keys
 *
 * These keys are used throughout the application.
 * Never hardcode storage keys anywhere else.
 */

export const STORAGE_KEYS = {

  ACCESS_TOKEN: 'access_token',

  REFRESH_TOKEN: 'refresh_token',

  CURRENT_USER: 'current_user',

  REMEMBER_ME: 'remember_me'

} as const;

export type StorageKey =
  typeof STORAGE_KEYS[keyof typeof STORAGE_KEYS];