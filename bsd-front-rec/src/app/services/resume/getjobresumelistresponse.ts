import { ViewJobResume } from './viewjobresume';

export class GetResumeListResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    lstViewJobResume: ViewJobResume[] = Array(new ViewJobResume());
    length: number;
}
