import { TbDepartment } from "./tbdepartment";

export class PostAddDepartmentRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbDepartment: TbDepartment = new TbDepartment();
}
