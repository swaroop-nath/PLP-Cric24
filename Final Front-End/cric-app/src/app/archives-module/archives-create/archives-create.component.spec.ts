import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArchivesCreateComponent } from './archives-create.component';

describe('ArchivesCreateComponent', () => {
  let component: ArchivesCreateComponent;
  let fixture: ComponentFixture<ArchivesCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArchivesCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArchivesCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
