import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { MatButtonModule} from '@angular/material/button';
import { MatInputModule} from '@angular/material/input';
import { MatNativeDateModule, MatRippleModule} from '@angular/material/core';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatTooltipModule} from '@angular/material/tooltip';
import { MatSelectModule} from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { LoginComponent } from 'app/pages/login/login.component';
import { LogoutComponent } from 'app/pages/logout/logout.component';
import { RegisterComponent } from 'app/pages/register/register.component';
import { ConfirmationComponent } from 'app/pages/confirmation/confirmation.component';
import { DepartmentsComponent } from 'app/pages/departments/departments.component';
import { DepartmentsDetailComponent } from 'app/pages/departments-detail/departments-detail.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatRadioModule } from '@angular/material/radio';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { JobsComponent } from 'app/pages/jobs/jobs.component';
import { MatIconModule } from '@angular/material/icon';
import { JobsDetailComponent } from 'app/pages/jobs-detail/jobs-detail.component';
import { ResumesDetailComponent } from 'app/pages/resumes-detail/resumes-detail.component';
import { ResumesComponent } from 'app/pages/resumes/resumes.component';
import { MatTableModule } from '@angular/material/table';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { CKEditorModule } from 'ckeditor4-angular';
import { JobsKanbanComponent } from 'app/pages/jobs-kanban/jobs-kanban.component';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NgxPayPalModule } from 'ngx-paypal';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatRippleModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTooltipModule,
    MatPaginatorModule,
    MatRadioModule,
    MatCheckboxModule,
    MatIconModule,
    MatProgressBarModule,
    MatTableModule,
    MatProgressSpinnerModule,
    CKEditorModule,
    DragDropModule,
    NgxPayPalModule,
    MatSlideToggleModule,
  ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    LoginComponent,
    RegisterComponent,
    ResumesComponent,
    ResumesDetailComponent,
    DepartmentsComponent,
    JobsComponent,
    DepartmentsDetailComponent,
    JobsDetailComponent,
    JobsKanbanComponent,
    ConfirmationComponent,
    LogoutComponent,
    TableListComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    UpgradeComponent,
  ]
})

export class AdminLayoutModule {}
