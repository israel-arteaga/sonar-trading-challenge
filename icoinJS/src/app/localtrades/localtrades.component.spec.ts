import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocaltradesComponent } from './localtrades.component';

describe('LocaltradesComponent', () => {
  let component: LocaltradesComponent;
  let fixture: ComponentFixture<LocaltradesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocaltradesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocaltradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
