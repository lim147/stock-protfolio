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
  
  stockToBuyName! : string;
  stockToBuyQty! : number;
  stockToBuySymbol! : string;

  stockToSellName! : string;
  stockToSellQty! : number;
  stockToSellSymbol! : string;

  constructor(private stockService : StockService) { }

  ngOnInit(): void {
  }

  buyStock(form: NgForm){
    this.stockService.buyStock(this.stockToBuySymbol, this.stockToBuyName, this.stockToBuyQty).subscribe({
      next: (data:any) => this.stocks.push(data),
      error: (_:any)  => console.log("Error")
    });
  }

  sellStock(form: NgForm){
    this.stockService.sellStock(this.stockToSellSymbol, this.stockToSellName, this.stockToSellQty).subscribe({
      next: (data:any) => this.stocks.push(data),
      error: (_:any)  => console.log("Error")
    });
  }


}
