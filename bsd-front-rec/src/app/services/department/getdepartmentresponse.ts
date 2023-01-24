import { TbDepartment } from './tbdepartment';

export class GetDepartmentResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbDepartment: TbDepartment = new TbDepartment();
}
