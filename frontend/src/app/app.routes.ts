import { Routes } from '@angular/router';

import { MainLayoutComponent } from './layouts/main-layout/main-layout';

import { LoginComponent } from './features/auth/login/login';

import { UnauthorizedComponent } from '../app/shared/pages/unauthorized/unauthorized';

import { NotFoundComponent } from '../app/shared/pages/not-found/not-found';

import { loginGuard } from '../app/core/guards/login-guard';

import { authGuard } from '../app/core/guards/auth-guard';

import { roleGuard } from '../app/core/guards/role-guard';

import { Role } from './core/enums/role.enum';

// import { DashboardComponent } from './features/dashboard/dashboard/dashboard';
// import { UserListComponent } from './features/users/user-list/user-list';
// import { DepartmentListComponent } from './features/departments/department-list/department-list';
// import { TicketListComponent } from './features/tickets/ticket-list/ticket-list';
// import { ReportsComponent } from './features/reports/reports/reports';
// import { NotificationCenterComponent } from './features/notifications/notification-center/notification-center';
// import { ProfileComponent } from './features/profile/profile/profile';
// import { ChatComponent } from './features/ai/chat/chat';
// import { DocumentListComponent } from './features/knowledge-base/document-list/document-list';

export const routes: Routes = [

  /**
   * Default Route
   */
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },

  /**
   * Authentication
   */
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [loginGuard]
  },

  /**
   * Unauthorized Page
   */
  {
    path: 'unauthorized',
    component: UnauthorizedComponent
  },

  /*
   * Protected Routes
   * (Uncomment as we build modules)
   */

  // {
  //   path: '',
  //   component: MainLayoutComponent,
  //   canActivate: [authGuard],
  //   children: [

  //     {
  //       path: 'dashboard',
  //       component: DashboardComponent
  //     },

  //     {
  //       path: 'users',
  //       component: UserListComponent,
  //       canActivate: [roleGuard],
  //       data: {
  //         roles: [
  //           Role.ADMIN,
  //           Role.SUPPORT_MANAGER
  //         ]
  //       }
  //     },

  //     {
  //       path: 'departments',
  //       component: DepartmentListComponent,
  //       canActivate: [roleGuard],
  //       data: {
  //         roles: [
  //           Role.ADMIN
  //         ]
  //       }
  //     },

  //     {
  //       path: 'tickets',
  //       component: TicketListComponent
  //     },

  //     {
  //       path: 'knowledge-base',
  //       component: DocumentListComponent
  //     },

  //     {
  //       path: 'ai',
  //       component: ChatComponent
  //     },

  //     {
  //       path: 'reports',
  //       component: ReportsComponent,
  //       canActivate: [roleGuard],
  //       data: {
  //         roles: [
  //           Role.ADMIN,
  //           Role.SUPPORT_MANAGER
  //         ]
  //       }
  //     },

  //     {
  //       path: 'notifications',
  //       component: NotificationCenterComponent
  //     },

  //     {
  //       path: 'profile',
  //       component: ProfileComponent
  //     }

  //   ]
  // },

  /**
   * 404 Page
   */
  {
    path: '404',
    component: NotFoundComponent
  },

  /**
   * Wildcard Route
   */
  {
    path: '**',
    redirectTo: '404'
  }

];