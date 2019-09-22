import { Injectable } from '@angular/core';
import { TypeDocumet } from '../model/type-documet';
import { Observable,of } from 'rxjs/index';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TypeDocumentService {
  baseUrl: string = 'http://localhost:8080/calendarActivities-rest/rest/tipoDocumento/';
  constructor(private http: HttpClient) { }

  getTypeDocument() : Observable<TypeDocumet[]> {
    return this.http.get<TypeDocumet[]>(this.baseUrl)
    .pipe(
      tap(_ => this.log('fetched clients')),
      catchError(this.handleError<TypeDocumet[]>('getTyperDocuments', []))
    );
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
