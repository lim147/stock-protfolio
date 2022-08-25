import { Component} from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})

export class MainpageComponent{
  transactions: Observable<Array<Transaction>>;
  constructor(transactionService: TransactionService) { 
    this.transactions = transactionService.getAllTransactions();

  }

}
