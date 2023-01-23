import { TbJobResume } from './tbjobresume';

export class PostAddJobResumeResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbJobResume: TbJobResume = new TbJobResume();
}
