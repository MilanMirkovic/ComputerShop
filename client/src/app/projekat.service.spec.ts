import { TestBed } from '@angular/core/testing';

import { ProjekatService } from './projekat.service';

describe('ProjekatService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProjekatService = TestBed.get(ProjekatService);
    expect(service).toBeTruthy();
  });
});
