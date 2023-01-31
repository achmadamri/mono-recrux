import { TbResume } from './tbresume';
import { TbResumeCertification } from './tbresumecertification';
import { TbResumeEducation } from './tbresumeeducation';
import { TbResumeSkill } from './tbresumeskill';
import { TbResumeWorkExperience } from './tbresumeworkexperience';

export class GetResumeResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbResume: TbResume = new TbResume();
    lstTbResumeCertification: TbResumeCertification[] = Array(new TbResumeCertification());
	lstTbResumeEducation: TbResumeEducation[] = Array(new TbResumeEducation());
	lstTbResumeSkillHard: TbResumeSkill[] = Array(new TbResumeSkill());
	lstTbResumeSkillSoft: TbResumeSkill[] = Array(new TbResumeSkill());
	lstTbResumeWorkExperience: TbResumeWorkExperience[] = Array(new TbResumeWorkExperience());
}
