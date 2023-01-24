import { TbJob } from "../job/tbjob";
import { TbDepartment } from "./tbdepartment";
import { TbDepartmentJob } from "./tbdepartmentjob";

export class PostAddDepartmentJobRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbDepartmentJob: TbDepartmentJob = new TbDepartmentJob();
    tbDepartment: TbDepartment = new TbDepartment();
    tbJob: TbJob = new TbJob();
}
