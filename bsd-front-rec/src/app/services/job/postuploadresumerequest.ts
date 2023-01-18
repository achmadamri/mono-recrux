import { TbJob } from "./tbjob";

export class PostUploadResumeRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbJob: TbJob = new TbJob();
}
