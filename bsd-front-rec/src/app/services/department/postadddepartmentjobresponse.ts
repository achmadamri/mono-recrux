import { TbDepartmentJob } from './tbdepartmentjob';

export class PostAddDepartmentJobResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbDepartmentJob: TbDepartmentJob = new TbDepartmentJob();
}
