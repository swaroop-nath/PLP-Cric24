import { TestBed } from '@angular/core/testing';

import { StadiumsService } from './stadiums-service.service';

describe('StadiumsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StadiumsService = TestBed.get(StadiumsService);
    expect(service).toBeTruthy();
  });
});
