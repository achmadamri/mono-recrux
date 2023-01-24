import { TbResume } from "./tbresume";

export class PostAddResumeRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbResume: TbResume = new TbResume();
}
