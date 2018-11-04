import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeneService {
  //need to change tthis just api path...remove host somewhhere...somehow...lol
  private url: string = "http://localhost:9000/api/v1";

  constructor(private http: HttpClient) { }

  public searchGeneNames(query: string): Observable<string[]> {
    return this.http.get<string[]>(`${this.url}/genes?name=${query}`);
  }
}
