import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { environment } from "src/environments/environment";
import { Game } from "../model/Game";

@Injectable({
    providedIn: 'root',
})
export class GameService {

    constructor(private httpClient: HttpClient){}

    getGames(): Observable<Game[]>{
        return this.httpClient.get<Game[]>(`${environment.API_URL}/products/all`);
    }
}
