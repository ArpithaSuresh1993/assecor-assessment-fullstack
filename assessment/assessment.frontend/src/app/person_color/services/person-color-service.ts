import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {PersonColorServiceIf, PERSON_SERVICE_BACKEND_URL} from './person-color-service-if';
import {PersonAndColorModel} from '../models/person-color-model'
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn:'root'
})

export class PersonColorService implements PersonColorServiceIf {

  private readonly url ;

  constructor(private httpClient: HttpClient, @Inject(PERSON_SERVICE_BACKEND_URL) serviceUrl: string)
  {
    this.url = serviceUrl;
  }

  private getURL(path: string)
  {
    return this.url + path;
  }

  private sendRequest<T>(verb: string, url: string, body?: any): Observable<T>
  {
    const myHeaders = new HttpHeaders();
    return this.httpClient.request<T>(verb, url, {
      body: body,
      headers: myHeaders
    })
    .pipe(catchError((error: Response) => {
      return throwError(error);
    })) ;
  }

  getPeople() : Observable< PersonAndColorModel[] >
  {
    return this.sendRequest<PersonAndColorModel[]>('GET', this.getURL('/persons'));
  }

  getPeopleWhoLoveTheSameColor(color : string) : Observable< PersonAndColorModel[] >
   {
     return this.sendRequest<PersonAndColorModel[]>('GET', this.getURL('/persons/color/' + color));
   }
}
