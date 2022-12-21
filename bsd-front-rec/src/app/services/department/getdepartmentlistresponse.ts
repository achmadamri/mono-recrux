import { TbDepartment } from './tbdepartment';

export class GetDepartmentListResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    lstTbDepartment: TbDepartment[] = Array(new TbDepartment());
    length: number;
}
