import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import * as _ from 'lodash';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Trade} from "./trade";

@Injectable()
export class TradesService {
  private DEFAULT_TRADES_URL: string = "http://localhost:8080/icoin/trades/";

  trades$: Observable<Trade[]>;

  constructor(private httpClient: HttpClient) {
  }

  getLatestTrades(n: string): Observable<Trade[]> {
    this.trades$ = this.httpClient.get<Trade[]>(this.DEFAULT_TRADES_URL+n).map(data => _.values(data));

    return this.trades$;
  }

}
