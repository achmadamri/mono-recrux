import { TbPayment } from './tbpayment';

export class PostAddResponse {
    requestId: string;
    requestDate: string;
    responseId: string;
    responseDate: string;
    status: string;
    error: string;
    message: string;
    tbPayment: TbPayment = new TbPayment();
}
