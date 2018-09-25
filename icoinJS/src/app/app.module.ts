import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { TradesComponent } from './trades/trades.component';
import { TradesService } from "./trades.service";
import { OrderbookService } from "./orderbook.service";
import { OrderbookComponent } from './orderbook/orderbook.component';
import {AppsettingsService} from "./appsettings.service";
import { LocaltradesComponent } from './localtrades/localtrades.component';
import {LocaltradesService} from "./localtrades.service";

@NgModule({
  declarations: [
    TradesComponent,
    OrderbookComponent,
    LocaltradesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [TradesService, LocaltradesService, OrderbookService, AppsettingsService],
  bootstrap: [TradesComponent, OrderbookComponent, LocaltradesComponent]
})
export class AppModule { }
