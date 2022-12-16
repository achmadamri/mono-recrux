import { TbEntry } from "./tbentry";

export class EntryAddRequest {
    email: string;
    token: string;
    requestId: string;
    requestDate: string;
    tbEntry: TbEntry = new TbEntry();
}
