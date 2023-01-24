import { TbDepartment } from "./tbdepartment";

export class GetDepartmentRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbDepartment: TbDepartment = new TbDepartment();
}
