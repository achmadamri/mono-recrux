import { TbJob } from "./tbjob";

export class GetJobDescriptionRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbJob: TbJob = new TbJob();
}
