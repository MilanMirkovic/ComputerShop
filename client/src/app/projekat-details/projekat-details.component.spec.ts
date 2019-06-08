import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjekatDetailsComponent } from './projekat-details.component';

describe('ProjekatDetailsComponent', () => {
  let component: ProjekatDetailsComponent;
  let fixture: ComponentFixture<ProjekatDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjekatDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjekatDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
