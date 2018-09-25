import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Trade} from "./trade";
import {HttpClient} from "@angular/common/http";
import * as _ from "lodash";

@Injectable()
export class LocaltradesService {
  private DEFAULT_LOCAL_TRADES_URL: string = "http://localhost:8080/icoin/trades/local/";

  localTrades$: Observable<Trade[]>;

  constructor(private httpClient: HttpClient) {
  }

  getLatestTrades(n: string, N: string, M: string): Observable<Trade[]> {
    this.localTrades$ = this.httpClient.get<Trade[]>(this.DEFAULT_LOCAL_TRADES_URL+n+'/'+N+'/'+M).map(data => _.values(data));

    return this.localTrades$;
  }

}
