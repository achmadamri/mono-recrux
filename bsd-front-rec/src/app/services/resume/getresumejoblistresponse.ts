import { ViewResumeJob } from "./viewresumejob";

export class GetResumeJobListResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    lstViewResumeJob: ViewResumeJob[] = Array(new ViewResumeJob());
    length: number;
}
