export class Transaction {
    constructor(
        public id: number,
        public stockSymbol: string,
        public name: string,
        public submittedDateTime: Date,
        public submittedPrice: number,
        public qty: number,
        public type: String) {
    }
}
