import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayersRetrieveAllComponent } from './players-retrieve-all.component';

describe('PlayersRetrieveAllComponent', () => {
  let component: PlayersRetrieveAllComponent;
  let fixture: ComponentFixture<PlayersRetrieveAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayersRetrieveAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayersRetrieveAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
