import { NavigationItem } from '../models/navigation-item.model';
import { UserRole } from '../enums/user-role.enum';

export const NAVIGATION: NavigationItem[] = [

{
title:'Dashboard',
icon:'dashboard',
route:'/dashboard',
roles:[
UserRole.ADMIN,
UserRole.MANAGER,
UserRole.ENGINEER,
UserRole.EMPLOYEE
]
},

{
title:'Users',
icon:'people',
route:'/users',
roles:[
UserRole.ADMIN
]
},

{
title:'Departments',
icon:'business',
route:'/departments',
roles:[
UserRole.ADMIN,
UserRole.MANAGER
]
},

{
title:'Tickets',
icon:'confirmation_number',
route:'/tickets',
roles:[
UserRole.ADMIN,
UserRole.MANAGER,
UserRole.ENGINEER,
UserRole.EMPLOYEE
]
},

{
title:'Reports',
icon:'analytics',
route:'/reports',
roles:[
UserRole.ADMIN,
UserRole.MANAGER
]
},

{
title:'Knowledge Base',
icon:'menu_book',
route:'/knowledge-base',
roles:[
UserRole.ADMIN,
UserRole.MANAGER,
UserRole.ENGINEER,
UserRole.EMPLOYEE
]
},

{
title:'AI Assistant',
icon:'smart_toy',
route:'/ai',
roles:[
UserRole.ADMIN,
UserRole.MANAGER,
UserRole.ENGINEER,
UserRole.EMPLOYEE
]
},

{
title:'Notifications',
icon:'notifications',
route:'/notifications',
roles:[
UserRole.ADMIN,
UserRole.MANAGER,
UserRole.ENGINEER,
UserRole.EMPLOYEE
]
},

{
title:'Profile',
icon:'person',
route:'/profile',
roles:[
UserRole.ADMIN,
UserRole.MANAGER,
UserRole.ENGINEER,
UserRole.EMPLOYEE
]
}

];