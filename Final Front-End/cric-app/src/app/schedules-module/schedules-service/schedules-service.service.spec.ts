import { TestBed } from '@angular/core/testing';

import { SchedulesService } from './schedules-service.service';

describe('SchedulesServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SchedulesService = TestBed.get(SchedulesService);
    expect(service).toBeTruthy();
  });
});
