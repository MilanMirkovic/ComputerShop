import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProccesorsComponent } from './proccesors.component';

describe('ProccesorsComponent', () => {
  let component: ProccesorsComponent;
  let fixture: ComponentFixture<ProccesorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProccesorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProccesorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
