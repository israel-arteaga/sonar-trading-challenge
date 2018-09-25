import { TestBed, inject } from '@angular/core/testing';

import { LocaltradesService } from './localtrades.service';

describe('LocaltradesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LocaltradesService]
    });
  });

  it('should be created', inject([LocaltradesService], (service: LocaltradesService) => {
    expect(service).toBeTruthy();
  }));
});
