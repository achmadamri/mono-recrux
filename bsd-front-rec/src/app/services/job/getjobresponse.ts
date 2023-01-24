import { TbJob } from './tbjob';

export class GetJobResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbJob: TbJob = new TbJob();
}
