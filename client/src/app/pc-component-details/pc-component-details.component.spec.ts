import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PcComponentDetailsComponent } from './pc-component-details.component';

describe('PcComponentDetailsComponent', () => {
  let component: PcComponentDetailsComponent;
  let fixture: ComponentFixture<PcComponentDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PcComponentDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PcComponentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
