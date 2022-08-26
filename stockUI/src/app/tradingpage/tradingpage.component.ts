import { Component} from '@angular/core';
import { Stock } from '../stock';
import { StockService } from '../stock.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-tradingpage',
  templateUrl: './tradingpage.component.html',
  styleUrls: ['./tradingpage.component.css']
})
export class TradingpageComponent {
  stocks! : Array<Stock>;

  stockName! : string;
  stockQty! : number;
  stockSymbol! : string;
  stockPrice! : number;

  tradingType! : string;
  messageDisplay : boolean = false;

  constructor(private stockService : StockService) { }

  ngOnInit(): void {
  }

  tradeStock(type : String, form: NgForm){
    if (type == 'buy'){
      this.buyStock(form);
      this.tradingType = 'buy';
    }
    if (type == 'sell'){
      this.sellStock(form);
      this.tradingType = 'sell';
    }
  }

  buyStock(form: NgForm){
    this.stockService.buyStock(this.stockSymbol, this.stockName, this.stockQty, this.stockPrice).subscribe({
      next: (data:any) => this.stocks.push(data),
      error: (_:any)  => console.log("Error")
    });
    this.messageDisplay = true;
  }

  sellStock(form: NgForm){
    this.stockService.sellStock(this.stockSymbol, this.stockName, this.stockQty, this.stockPrice).subscribe({
      next: (data:any) => this.stocks.push(data),
      error: (_:any)  => console.log("Error")
    });
    this.messageDisplay = true;
  }


}
