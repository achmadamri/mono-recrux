import { TbJob } from "./tbjob";

export class PostAddJobRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbJob: TbJob = new TbJob();
}
