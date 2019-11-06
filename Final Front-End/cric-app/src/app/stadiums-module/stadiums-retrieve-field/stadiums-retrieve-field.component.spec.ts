import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumsRetrieveFieldComponent } from './stadiums-retrieve-field.component';

describe('StadiumsRetrieveFieldComponent', () => {
  let component: StadiumsRetrieveFieldComponent;
  let fixture: ComponentFixture<StadiumsRetrieveFieldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StadiumsRetrieveFieldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StadiumsRetrieveFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
