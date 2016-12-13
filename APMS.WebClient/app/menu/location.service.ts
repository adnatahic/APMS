import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/do";
import "rxjs/add/operator/catch";

import { EncodedMessage } from '../encoded-message';

@Injectable()
export class LocationService {
    private _locationUrl="http://localhost:8080/api/encodedmessages";

    constructor(private _http: Http) { }

    getLocations(): Observable<EncodedMessage[]> {
        return this._http.get(this._locationUrl)
        .map((response: Response) => <EncodedMessage[]> response.json())
        .catch(this.handleError);
    }

     private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}