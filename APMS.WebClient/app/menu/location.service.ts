import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/do";
import "rxjs/add/operator/catch";

import { Location } from '../Location';

@Injectable()
export class LocationService {
    private _locationUrl="http://localhost:8080/api/encodedMessages";

    constructor(private _http: Http) { }

    getLocations(): Observable<any[]> {
        let _header = new Headers();
        _header.append('Content-Type', 'application/json');

        return this._http.get(this._locationUrl, { headers: _header})
        .map((response: Response) => <any[]> response.json().locations)
        .catch(this.handleError);
    }

     private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}