import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex8Home } from './ex8-home';

describe('Ex8Home', () => {
  let component: Ex8Home;
  let fixture: ComponentFixture<Ex8Home>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex8Home]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex8Home);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
