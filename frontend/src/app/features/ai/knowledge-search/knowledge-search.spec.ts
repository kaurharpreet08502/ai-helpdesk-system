import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnowledgeSearch } from './knowledge-search';

describe('KnowledgeSearch', () => {
  let component: KnowledgeSearch;
  let fixture: ComponentFixture<KnowledgeSearch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KnowledgeSearch],
    }).compileComponents();

    fixture = TestBed.createComponent(KnowledgeSearch);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
