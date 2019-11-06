import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBloggersComponent } from './get-bloggers.component';

describe('GetBloggersComponent', () => {
  let component: GetBloggersComponent;
  let fixture: ComponentFixture<GetBloggersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetBloggersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetBloggersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
