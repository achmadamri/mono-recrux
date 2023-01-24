import { TbJob } from "../job/tbjob";
import { TbResume } from "../resume/tbresume";
import { TbJobResume } from "./tbjobresume";

export class PostAddJobResumeRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbJobResume: TbJobResume = new TbJobResume();
    tbResume: TbResume = new TbResume();
    tbJob: TbJob = new TbJob();
}
