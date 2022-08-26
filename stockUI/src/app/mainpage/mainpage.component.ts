import { Component} from '@angular/core';
import { Stock } from '../stock';
import { StockService } from '../stock.service';
import { FormControl, FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})

export class MainpageComponent {
  searchFilters: string[] = ['Symbol', 'Name'];
  searchFilterForm: FormGroup;
  selectedValue: any;
  stocks! : Array<Stock>;
  searchSymbol! : string;
  searchName! : string;

  constructor(private stockService : StockService) {
    this.searchFilterForm = new FormGroup({
      searchFilter: new FormControl(null)
    });
  }

  ngOnInit(): void {
    this.getAllStocks();
  }

  setSearchFilterType() {
    this.selectedValue = this.searchFilterForm.value.searchFilter;
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

  searchStockByName(form: NgForm){
    this.stocks = [];
    this.stockService.getStockByName(this.searchName).subscribe({
      next: (data:any) => this.stocks.push(data),
      error: (_:any)  => console.log("Error")
    });
  }

}


