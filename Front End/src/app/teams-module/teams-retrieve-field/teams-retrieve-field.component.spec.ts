import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamsRetrieveFieldComponent } from './teams-retrieve-field.component';

describe('TeamsRetrieveFieldComponent', () => {
  let component: TeamsRetrieveFieldComponent;
  let fixture: ComponentFixture<TeamsRetrieveFieldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamsRetrieveFieldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamsRetrieveFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
