import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";

@Injectable({
    providedIn: 'root'
})
export class ContratService {
    readonly API_URL = 'http://192.168.1.13:8089/kaddem/contrat';

    constructor(private httpClient: HttpClient) { }

    getAllContrats() {
        return this.httpClient.get(`${this.API_URL}/retrieve-all-contrats`)
    }
    addContrat(contrat : any) {
        return this.httpClient.post(`${this.API_URL}/add-contrat`, contrat)
    }
    updateContrat(data: any):Observable<any>{
        return this.httpClient.put<any>(`${this.API_URL}/update-contrat`,data);
    }
    deleteContrat(id: any): Observable<any> {
        return this.httpClient.delete<any>(`${this.API_URL}/remove-contrat/${id}`);
    }

}