import { TbJob } from './tbjob';

export class GetJobListResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    lstTbJob: TbJob[] = Array(new TbJob());
    length: number;
}
