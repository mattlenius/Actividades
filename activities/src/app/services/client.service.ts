import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable,of } from 'rxjs/index';
import { Client } from '../model/client';
import { ApiResponse  } from '../model/api-response';

import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/calendarActivities-rest/rest/cliente/';


  getClients() : Observable<Client[]> {
    return this.http.get<Client[]>(this.baseUrl)
    .pipe(
      tap(_ => this.log('fetched clients')),
      catchError(this.handleError<Client[]>('getClients', []))
    );
  }

  getClientById(id: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.baseUrl + id);
  }

  createClient(client: Client): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, client);
  }

  updateClient(client: Client): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + client.clieId, client);
  }

  deleteClient(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }

   /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


   /** Log a HeroService message with the MessageService */
   private log(message: string) {
    //this.messageService.add(`HeroService: ${message}`);
  }

}
