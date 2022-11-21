import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

import { Observable } from "rxjs/internal/Observable";
import { environment } from "src/environments/environment";
import { Game } from "../model/Game";

@Injectable()
export class GameService {
    private url: string = `${environment.API_URL}/products/all`;

    constructor(private httpClient: HttpClient){}

    getGames(): Observable<Game[]>{
        return this.httpClient.get<Game[]>(this.url);
    }

}