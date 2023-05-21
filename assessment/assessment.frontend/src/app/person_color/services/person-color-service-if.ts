import {InjectionToken} from "@angular/core";
import {Observable} from "rxjs";
import {PersonAndColorModel} from '../models/person-color-model'

export const PERSON_SERVICE_BACKEND_URL: InjectionToken<string> = new InjectionToken<string>('PERSON_SERVICE_BACKEND_URL');

export const PERSON_SERVICE_TOKEN: InjectionToken<PersonColorServiceIf> =
  new InjectionToken<PersonColorServiceIf>('PERSON_SERVICE_TOKEN');

export interface PersonColorServiceIf
{
    /**
     * Returns a list of people.
    */
    getPeople() :  Observable< PersonAndColorModel[] >;

    getPeopleWhoLoveTheSameColor(color : string) : Observable< PersonAndColorModel[] >;
}
