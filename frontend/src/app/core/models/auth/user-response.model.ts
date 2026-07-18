export interface UserResponse {

    /**
     * Primary Key
     */
    id: number;

    /**
     * Employee ID
     */
    employeeId: string;

    /**
     * First Name
     */
    firstName: string;

    /**
     * Last Name
     */
    lastName: string;

    /**
     * Full Name
     * (Optional - backend can populate)
     */
    fullName?: string;

    /**
     * Email Address
     */
    email: string;

    /**
     * Contact Number
     */
    phoneNumber?: string;

    /**
     * Role
     * Example:
     * ROLE_ADMIN
     * ROLE_SUPPORT_MANAGER
     * ROLE_SUPPORT_ENGINEER
     * ROLE_EMPLOYEE
     */
    role: string;

    /**
     * Department ID
     */
    departmentId: number;

    /**
     * Department Name
     */
    departmentName: string;

    /**
     * Manager ID
     */
    managerId?: number;

    /**
     * Profile Image URL
     */
    profileImage?: string;

    /**
     * Employee Status
     */
    active: boolean;

}