import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KategorijaStranicaComponent } from './kategorija-stranica.component';

describe('KategorijaStranicaComponent', () => {
  let component: KategorijaStranicaComponent;
  let fixture: ComponentFixture<KategorijaStranicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KategorijaStranicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KategorijaStranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
