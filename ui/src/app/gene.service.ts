import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeneService {
  //TODO: need to change this api path...remove host somewhere.
  private url: string = "http://localhost:9000/api/v1";

  constructor(private http: HttpClient) { }

  public searchGeneNames(query: string): Observable<string[]> {
    return this.http.get<string[]>(`${this.url}/genes?name=${query}`);
  }

  public searchGeneVariants(geneName: string): Observable<GeneVariant[]> {
    return this.http.get<GeneVariant[]>(`${this.url}/geneVariants?geneName=${geneName}`);
  }
}
