import { Component, OnInit } from '@angular/core';
import {TradesService} from "../trades.service";
import {Trade} from "../trade";
import {Observable} from "rxjs";
import {AppSettings} from "../app-settings";
import {AppsettingsService} from "../appsettings.service";


@Component({
  selector: 'app-trades',
  templateUrl: './trades.component.html',
  styleUrls: ['./trades.component.css']
})
export class TradesComponent implements OnInit {

  private TIME_INTERVAL_IN_SECONDS : number = 5000; //5 seconds
  private xRecentTrades: string;
  private appSettings: AppSettings;
  trades: Trade[] = [];

  constructor(private tradesService: TradesService, private appsettingsService: AppsettingsService) {

  }

  ngOnInit() {

    this.appsettingsService.getSettings()
      .subscribe(appSettings => this.appSettings = appSettings,
        () => null,
        () => {
          this.xRecentTrades = this.appSettings.xRecentTrades;
        });

    Observable.interval(this.TIME_INTERVAL_IN_SECONDS).subscribe((x) => {
      this.tradesService.getLatestTrades(this.xRecentTrades).subscribe( t => this.trades= t);
    });

  }

}
