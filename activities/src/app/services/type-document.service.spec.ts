import { TestBed } from '@angular/core/testing';

import { TypeDocumentService } from './type-document.service';

describe('TypeDocumentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TypeDocumentService = TestBed.get(TypeDocumentService);
    expect(service).toBeTruthy();
  });
});
