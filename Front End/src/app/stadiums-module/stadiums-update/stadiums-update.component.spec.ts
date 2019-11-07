import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumsUpdateComponent } from './stadiums-update.component';

describe('StadiumsUpdateComponent', () => {
  let component: StadiumsUpdateComponent;
  let fixture: ComponentFixture<StadiumsUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StadiumsUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StadiumsUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
