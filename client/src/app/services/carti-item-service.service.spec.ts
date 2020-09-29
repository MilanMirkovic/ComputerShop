import { TestBed } from '@angular/core/testing';

import { CartiItemServiceService } from './carti-item-service.service';

describe('CartiItemServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CartiItemServiceService = TestBed.get(CartiItemServiceService);
    expect(service).toBeTruthy();
  });
});
