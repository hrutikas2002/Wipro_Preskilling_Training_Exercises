import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex4CustomeDirective } from './ex4-custome-directive';

describe('Ex4CustomeDirective', () => {
  let component: Ex4CustomeDirective;
  let fixture: ComponentFixture<Ex4CustomeDirective>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex4CustomeDirective]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex4CustomeDirective);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
