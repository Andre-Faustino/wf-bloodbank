import { LoadingService } from './util/loading.service';
import { environment } from './../../environments/environment';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';




@Injectable({
  providedIn: 'root'
})
export class DonatorsService {

  headers : HttpHeaders =  new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
  
  httpOptions = {
    headers: this.headers
  }

  loading$ = this.loader.loading$;
  

  constructor(private httpClient : HttpClient, public loader: LoadingService) {
    
  }

  postDonatorsBatch(json : JSON): Observable<JSON> {
    console.log(environment.baseUrl);
    let url = environment.baseUrl + '/donator/batch';
    
    
    return this.httpClient.post<JSON>(url, json, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)

      )
  }

  getDonatorsData(path : String): Observable<JSON> {
    console.log(environment.baseUrl);
    let url = environment.baseUrl + path;
    
    
    return this.httpClient.get<JSON>(url, {headers : this.headers})
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }


  handleError(error: HttpErrorResponse) {
    console.log("ENTROUR AQUI")
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `mensagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };

  
}
