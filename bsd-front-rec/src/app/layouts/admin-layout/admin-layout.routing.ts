import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { LoginComponent } from 'app/pages/login/login.component';
import { AuthGuard } from 'app/auth.guard';
import { LogoutComponent } from 'app/pages/logout/logout.component';
import { RegisterComponent } from 'app/pages/register/register.component';
import { ConfirmationComponent } from 'app/pages/confirmation/confirmation.component';
import { DepartmentsComponent } from 'app/pages/departments/departments.component';
import { DepartmentsDetailComponent } from 'app/pages/departments-detail/departments-detail.component';
import { JobsComponent } from 'app/pages/jobs/jobs.component';

export const AdminLayoutRoutes: Routes = [
    // {
    //   path: '',
    //   children: [ {
    //     path: 'dashboard',
    //     component: DashboardComponent
    // }]}, {
    // path: '',
    // children: [ {
    //   path: 'userprofile',
    //   component: UserProfileComponent
    // }]
    // }, {
    //   path: '',
    //   children: [ {
    //     path: 'icons',
    //     component: IconsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'notifications',
    //         component: NotificationsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'maps',
    //         component: MapsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'typography',
    //         component: TypographyComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'upgrade',
    //         component: UpgradeComponent
    //     }]
    // }
    { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
    { path: 'user-profile', component: UserProfileComponent, canActivate: [AuthGuard] },
    { path: 'table-list', component: TableListComponent, canActivate: [AuthGuard] },
    { path: 'typography', component: TypographyComponent, canActivate: [AuthGuard] },
    { path: 'icons', component: IconsComponent, canActivate: [AuthGuard] },
    { path: 'maps', component: MapsComponent, canActivate: [AuthGuard] },
    { path: 'notifications', component: NotificationsComponent, canActivate: [AuthGuard] },
    { path: 'upgrade', component: UpgradeComponent, canActivate: [AuthGuard] },

    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'confirmation', component: ConfirmationComponent },
    { path: 'departments', component: DepartmentsComponent, canActivate: [AuthGuard] },
    { path: 'departments/:tbdUuid', component: DepartmentsDetailComponent, canActivate: [AuthGuard] },
    { path: 'jobs', component: JobsComponent, canActivate: [AuthGuard] },
    { path: 'logout', component: LogoutComponent },
];
