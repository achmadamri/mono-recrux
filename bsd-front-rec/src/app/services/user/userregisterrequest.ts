import { TbCompany } from "./tbcompany";
import { TbUser } from "./tbuser";

export class UserRegisterRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbUser: TbUser = new TbUser();
    agree: string;
    tbCompany: TbCompany = new TbCompany();
}
