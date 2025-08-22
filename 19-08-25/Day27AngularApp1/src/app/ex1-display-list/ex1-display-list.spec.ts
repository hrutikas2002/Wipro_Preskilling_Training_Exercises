import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex1DisplayList } from './ex1-display-list';

describe('Ex1DisplayList', () => {
  let component: Ex1DisplayList;
  let fixture: ComponentFixture<Ex1DisplayList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex1DisplayList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex1DisplayList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
