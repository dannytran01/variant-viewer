import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeneService {
  private _url: string = "http://localhost:9000/api/v1";

  constructor(private http: HttpClient) { }

  public searchGeneNames(query: string): Observable<string[]> {
    return this.http.get<string[]>(`${this._url}/genes?prefix=${query}`);
  }

  public searchGeneVariants(geneName: string): Observable<GeneVariant[]> {
    return this.http.get<GeneVariant[]>(`${this._url}/geneVariants?geneName=${geneName}`);
  }
}
