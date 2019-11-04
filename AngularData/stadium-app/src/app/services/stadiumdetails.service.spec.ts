import { TestBed } from '@angular/core/testing';

import { StadiumdetailsService } from './stadiumdetails.service';

describe('StadiumdetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StadiumdetailsService = TestBed.get(StadiumdetailsService);
    expect(service).toBeTruthy();
  });
});
