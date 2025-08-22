import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex8Task } from './ex8-task';

describe('Ex8Task', () => {
  let component: Ex8Task;
  let fixture: ComponentFixture<Ex8Task>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex8Task]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex8Task);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
