import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/do";
import "rxjs/add/operator/catch";

import { Node } from './node';

@Injectable()
export class NodeService {
    private _nodeUrl="http://localhost:8080/api/nodes";

    constructor(private _http: Http) { }

    getNodes(neLat: number, neLng: number, swLat: number, swLng: number): Observable<Node[]> {
        let url = this._nodeUrl;
        url += "?neLat=" + neLat;
        url += "&neLng=" + neLng;
        url += "&swLat=" + swLat;
        url += "&swLng=" + swLng;

     return this._http.get(url)
        .map((response: Response) => <Node[]> response.json())
        .catch(this.handleError);
    }

     private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || "Server error");
    }
}