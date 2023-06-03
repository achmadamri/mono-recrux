import { TbPayment } from "./tbpayment";

export class PostAddRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbPayment: TbPayment = new TbPayment();
}
