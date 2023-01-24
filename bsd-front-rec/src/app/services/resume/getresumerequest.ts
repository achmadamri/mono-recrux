import { TbResume } from "./tbresume";

export class GetResumeRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbResume: TbResume = new TbResume();
}
