import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/do";
import "rxjs/add/operator/catch";

import { Message } from './message';

@Injectable()
export class MessageService {
    private _messageUrl ="http://localhost:8080/api/message";

    constructor(private _http: Http) { }

    getLatestMessage(nodeId: number): Observable<Message> {
        let url = this._messageUrl;
        url += "?nodeId=" + nodeId;
 
     return this._http.get(url)
        .map((response: Response) => <Message> response.json())
        .catch(this.handleError);
    }

     private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}