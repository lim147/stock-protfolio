import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TradingpageComponent } from './tradingpage.component';

describe('TradingpageComponent', () => {
  let component: TradingpageComponent;
  let fixture: ComponentFixture<TradingpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TradingpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TradingpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
