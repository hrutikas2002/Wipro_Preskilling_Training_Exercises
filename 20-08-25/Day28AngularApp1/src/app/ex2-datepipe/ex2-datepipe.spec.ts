import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex2Datepipe } from './ex2-datepipe';

describe('Ex2Datepipe', () => {
  let component: Ex2Datepipe;
  let fixture: ComponentFixture<Ex2Datepipe>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex2Datepipe]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex2Datepipe);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
