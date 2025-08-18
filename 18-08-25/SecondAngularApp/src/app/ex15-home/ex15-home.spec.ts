import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex15Home } from './ex15-home';

describe('Ex15Home', () => {
  let component: Ex15Home;
  let fixture: ComponentFixture<Ex15Home>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex15Home]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex15Home);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
