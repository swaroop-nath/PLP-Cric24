import { TestBed } from '@angular/core/testing';

import { CricketService } from './cricket-service.service';

describe('CricketServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CricketService = TestBed.get(CricketService);
    expect(service).toBeTruthy();
  });
});
