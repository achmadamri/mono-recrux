import { TbUser } from './tbuser';

export class UserConfirmationPaymentResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbUsers: TbUser = new TbUser();
}
