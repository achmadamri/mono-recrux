import { TbDepartmentJob } from "./tbdepartmentjob";

export class PostAddDepartmentJobRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbDepartmentJob: TbDepartmentJob = new TbDepartmentJob();
}
