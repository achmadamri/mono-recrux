import { TbUser } from "../user/tbuser";
import { ViewDashJobCompletion } from "./viewdashjobcompletion";
import { ViewDashJobFill } from "./viewdashjobfill";

export class GetDashboardResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbUser: TbUser = new TbUser();
    parseLimit: number;
    token: number;
    totalJob: number;
    totalResume: number;
    lstViewDashJobFill: ViewDashJobFill[] = Array(new ViewDashJobFill());
    lstViewDashJobCompletion: ViewDashJobCompletion[] = Array(new ViewDashJobCompletion());
}
