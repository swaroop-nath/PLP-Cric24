import { TestBed } from '@angular/core/testing';

import { ArchivesService } from './archives-service.service';

describe('ArchivesServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ArchivesService- = TestBed.get(ArchivesServiceService);
    expect(service).toBeTruthy();
  });
});
