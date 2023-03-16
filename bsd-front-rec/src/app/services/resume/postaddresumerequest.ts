import { TbResume } from "./tbresume";
import { TbResumeEducation } from "./tbresumeeducation";
import { TbResumeWorkExperience } from "./tbresumeworkexperience";

export class PostAddResumeRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbResume: TbResume = new TbResume();
	lstTbResumeEducation: TbResumeEducation[] = Array(new TbResumeEducation());
	lstTbResumeWorkExperience: TbResumeWorkExperience[] = Array(new TbResumeWorkExperience());
}
