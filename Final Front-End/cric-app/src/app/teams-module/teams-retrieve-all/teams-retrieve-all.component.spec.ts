import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamsRetrieveAllComponent } from './teams-retrieve-all.component';

describe('TeamsRetrieveAllComponent', () => {
  let component: TeamsRetrieveAllComponent;
  let fixture: ComponentFixture<TeamsRetrieveAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamsRetrieveAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamsRetrieveAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
