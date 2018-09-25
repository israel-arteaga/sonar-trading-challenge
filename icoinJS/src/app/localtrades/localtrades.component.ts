import { Component, OnInit } from '@angular/core';
import {AppSettings} from "../app-settings";
import {Trade} from "../trade";
import {TradesService} from "../trades.service";
import {AppsettingsService} from "../appsettings.service";
import {Observable} from "rxjs";
import {LocaltradesService} from "../localtrades.service";

@Component({
  selector: 'app-localtrades',
  templateUrl: './localtrades.component.html',
  styleUrls: ['./localtrades.component.css']
})
export class LocaltradesComponent implements OnInit {

  private TIME_INTERVAL_IN_SECONDS : number = 5000; //5 seconds
  private xRecentTrades: string;
  private mConsecutiveUpTricks: string;
  private nConsecutiveDownTricks: string;
  private appSettings: AppSettings;
  localTrades: Trade[] = [];

  constructor(private tradesService: LocaltradesService, private appsettingsService: AppsettingsService) {

  }

  ngOnInit() {

    this.appsettingsService.getSettings()
      .subscribe(appSettings => this.appSettings = appSettings,
        () => null,
        () => {
          this.xRecentTrades = this.appSettings.xRecentTrades;
          this.mConsecutiveUpTricks = this.appSettings.mConsecutiveUpTricks;
          this.nConsecutiveDownTricks = this.appSettings.nConsecutiveDownTricks;
        });

    Observable.interval(this.TIME_INTERVAL_IN_SECONDS).subscribe((x) => {
      this.tradesService.getLatestTrades(this.xRecentTrades, this.mConsecutiveUpTricks, this.nConsecutiveDownTricks).subscribe( t => this.localTrades= t);
    });

  }

}
