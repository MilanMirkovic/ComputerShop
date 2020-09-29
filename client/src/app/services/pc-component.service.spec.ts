import { TestBed } from '@angular/core/testing';

import { PcComponentService } from './pc-component.service';

describe('PcComponentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PcComponentService = TestBed.get(PcComponentService);
    expect(service).toBeTruthy();
  });
});
