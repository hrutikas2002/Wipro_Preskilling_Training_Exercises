import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex5Home } from './ex5-home';

describe('Ex5Home', () => {
  let component: Ex5Home;
  let fixture: ComponentFixture<Ex5Home>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex5Home]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex5Home);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
