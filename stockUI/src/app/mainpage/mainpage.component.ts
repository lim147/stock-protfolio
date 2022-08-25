import { Component} from '@angular/core';
import { Stock } from '../stock';
import { StockService } from '../stock.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})

export class MainpageComponent {
  stocks! : Array<Stock>;
  searchSymbol! : string;

  constructor(private stockService : StockService) { }

  ngOnInit(): void {
    this.getAllStocks();
  }

  getAllStocks(){
    this.stockService.getAllStocks().subscribe({
      next: (data:any) => this.stocks = data,
      error: (_:any)  => console.log("Error")
    });
  }

  searchStockBySymbol(form: NgForm){
    this.stocks = [];
    this.stockService.getStockBySymbol(this.searchSymbol).subscribe({
      next: (data:any) => this.stocks.push(data),
      error: (_:any)  => console.log("Error")
    });
  }


}


