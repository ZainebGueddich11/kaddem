import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";

@Injectable({
    providedIn: 'root'
})
export class EquipeService {
    readonly API_URL = 'http://192.168.1.13:8089/kaddem/equipe';

    constructor(private httpClient: HttpClient) { }

    getAllEquipes() {
        return this.httpClient.get(`${this.API_URL}/retrieve-all-equipes`)
    }
    addEquipe(equipe : any) {
        return this.httpClient.post(`${this.API_URL}/add-equipe`, equipe)
    }
    updateEquipe(data: any):Observable<any>{
        return this.httpClient.put<any>(`${this.API_URL}/update-equipe`,data);
    }
    deleteEquipe(id: any): Observable<any> {
        return this.httpClient.delete<any>(`${this.API_URL}/remove-equipe/${id}`);
    }

}