import { TbResume } from './tbresume';

export class GetResumeListResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    lstTbResume: TbResume[] = Array(new TbResume());
    length: number;
}
