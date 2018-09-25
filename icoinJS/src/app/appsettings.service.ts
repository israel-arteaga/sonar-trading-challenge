import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { AppSettings } from "./app-settings";
import * as _ from "lodash";
@Injectable()
export class AppsettingsService {

  constructor(private http: HttpClient) {
  }
  getSettings(): Observable<AppSettings> {
    return this.http.get<AppSettings>("./assets/appsettings.json")
      .catch(this.handleErrors);
  }

  private handleErrors(error: any): Observable<any> {
    console.error('An error occurred while reading appSettings!', error);
    return Observable.throw(error.message || error);
  }

}
