import { TestBed } from '@angular/core/testing';

import { KategorijeService } from './kategorije.service';

describe('KategorijeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KategorijeService = TestBed.get(KategorijeService);
    expect(service).toBeTruthy();
  });
});
