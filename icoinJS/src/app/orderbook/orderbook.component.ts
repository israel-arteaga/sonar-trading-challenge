import { Component, OnInit } from '@angular/core';
import { OrderbookService } from "../orderbook.service";
import {AskBid} from "../ask-bid";
import {Observable} from "rxjs";
import { AppSettings } from "../app-settings";
import { AppsettingsService } from "../appsettings.service"

@Component({
  selector: 'app-orderbook',
  templateUrl: './orderbook.component.html',
  styleUrls: ['./orderbook.component.css']
})
export class OrderbookComponent implements OnInit {

  private TIME_INTERVAL_IN_SECONDS : number = 5000; //5 seconds
  private xBestAsksAndBids: string;
  private appSettings: AppSettings;

  bestAskAndBids: AskBid[] = [];

  constructor(private orderbookService: OrderbookService, private appsettingsService: AppsettingsService) {

  }

  ngOnInit() {

    this.appsettingsService.getSettings()
      .subscribe(appSettings => this.appSettings = appSettings,
        () => null,
        () => {
          this.xBestAsksAndBids = this.appSettings.xBestAsksAndBids;
        });

    Observable.interval(this.TIME_INTERVAL_IN_SECONDS).subscribe((x) => {
      this.orderbookService.getXBestAsksAndBids(this.xBestAsksAndBids).subscribe( t => this.bestAskAndBids= t);
    });

  }

}
