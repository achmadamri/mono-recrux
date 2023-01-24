import { TbResume } from './tbresume';

export class PostAddResumeResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbResume: TbResume = new TbResume();
}
