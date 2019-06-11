import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterProjekatComponent } from './filter-projekat.component';

describe('FilterProjekatComponent', () => {
  let component: FilterProjekatComponent;
  let fixture: ComponentFixture<FilterProjekatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilterProjekatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterProjekatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
