import { TestBed } from '@angular/core/testing';

import { RagistrationserviceService } from './ragistrationservice.service';

describe('RagistrationserviceService', () => {
  let service: RagistrationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RagistrationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
