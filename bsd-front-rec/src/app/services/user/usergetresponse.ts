import { TbCompany } from './tbcompany';
import { TbUser } from './tbuser';
import { ViewUserMenu } from './viewusermenu';

export class UserGetResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbUser: TbUser = new TbUser();
    tbCompany: TbCompany = new TbCompany();
    lstViewUserMenu: ViewUserMenu[] = Array(new ViewUserMenu());
}
