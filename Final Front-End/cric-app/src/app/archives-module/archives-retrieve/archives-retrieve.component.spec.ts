import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArchivesRetrieveComponent } from './archives-retrieve.component';

describe('ArchivesRetrieveComponent', () => {
  let component: ArchivesRetrieveComponent;
  let fixture: ComponentFixture<ArchivesRetrieveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArchivesRetrieveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArchivesRetrieveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
