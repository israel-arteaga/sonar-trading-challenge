import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import * as _ from 'lodash';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {AskBid} from "./ask-bid";

@Injectable()
export class OrderbookService {

  private DEFAULT_ORDERBOOK_URL: string = "http://localhost:8080/icoin/orderbook/";

  bestAsksAndBids$: Observable<AskBid[]>;

  constructor(private httpClient: HttpClient) {
  }

  getXBestAsksAndBids(bestX:string): Observable<AskBid[]> {
    this.bestAsksAndBids$ = this.httpClient.get<AskBid[]>(this.DEFAULT_ORDERBOOK_URL+bestX).map(data => _.values(data));

    return this.bestAsksAndBids$;
  }

}
