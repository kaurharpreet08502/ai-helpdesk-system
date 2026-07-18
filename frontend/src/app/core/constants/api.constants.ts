/**
 * Application API Configuration
 */

export const API_CONFIG = {

  BASE_URL: 'http://localhost:8080/api/v1',

  AUTH: {

    LOGIN: '/auth/login',

    LOGOUT: '/auth/logout',

    REFRESH_TOKEN: '/auth/refresh-token',

    FORGOT_PASSWORD: '/auth/forgot-password',

    RESET_PASSWORD: '/auth/reset-password',

    CURRENT_USER: '/auth/me'

  },

  USERS: {

    GET_ALL: '/users',

    GET_BY_ID: '/users',

    CREATE: '/users',

    UPDATE: '/users',

    DELETE: '/users'

  },

  DEPARTMENTS: {

    GET_ALL: '/departments',

    GET_BY_ID: '/departments',

    CREATE: '/departments',

    UPDATE: '/departments',

    DELETE: '/departments'

  },

  TICKETS: {

    GET_ALL: '/tickets',

    GET_BY_ID: '/tickets',

    CREATE: '/tickets',

    UPDATE: '/tickets',

    DELETE: '/tickets',

    ASSIGN: '/tickets/assign',

    CHANGE_STATUS: '/tickets/status'

  },

  KNOWLEDGE_BASE: {

    GET_ALL: '/knowledge-base',

    UPLOAD: '/knowledge-base/upload',

    DELETE: '/knowledge-base'

  },

  AI: {

    CHAT: '/ai/chat',

    SEARCH: '/ai/search'

  },

  DASHBOARD: {

    SUMMARY: '/dashboard'

  }

} as const;