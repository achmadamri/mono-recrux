import { ViewJobDepartment } from './viewjobdepartment';

export class GetJobDepartmentListResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    lstViewJobDepartment: ViewJobDepartment[] = Array(new ViewJobDepartment());
    length: number;
}
