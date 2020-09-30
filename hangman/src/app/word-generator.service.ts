import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResultHangman } from './result.model';

@Injectable({
  providedIn: 'root'
})
export class WordGeneratorService {

  constructor(private http: HttpClient) { }

  /** GET heroes from the server */
  public getWord(): Observable<ResultHangman> {
    return this.http.get<ResultHangman>("http://localhost:8080/getWordFromList")
  }
}
