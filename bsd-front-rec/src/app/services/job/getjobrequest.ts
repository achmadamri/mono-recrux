import { TbJob } from "./tbjob";

export class GetJobRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbJob: TbJob = new TbJob();
}
