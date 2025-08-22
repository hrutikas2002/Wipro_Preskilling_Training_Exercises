import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex5Fruits } from './ex5-fruits';

describe('Ex5Fruits', () => {
  let component: Ex5Fruits;
  let fixture: ComponentFixture<Ex5Fruits>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex5Fruits]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex5Fruits);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
