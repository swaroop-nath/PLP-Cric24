import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayersRetrieveFieldComponent } from './players-retrieve-field.component';

describe('PlayersRetrieveFieldComponent', () => {
  let component: PlayersRetrieveFieldComponent;
  let fixture: ComponentFixture<PlayersRetrieveFieldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayersRetrieveFieldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayersRetrieveFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
