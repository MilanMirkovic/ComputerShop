import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KategorijeNaviagationBarComponent } from './kategorije-naviagation-bar.component';

describe('KategorijeNaviagationBarComponent', () => {
  let component: KategorijeNaviagationBarComponent;
  let fixture: ComponentFixture<KategorijeNaviagationBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KategorijeNaviagationBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KategorijeNaviagationBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
