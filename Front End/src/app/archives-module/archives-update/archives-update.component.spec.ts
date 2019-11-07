import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArchivesUpdateComponent } from './archives-update.component';

describe('ArchivesUpdateComponent', () => {
  let component: ArchivesUpdateComponent;
  let fixture: ComponentFixture<ArchivesUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArchivesUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArchivesUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
