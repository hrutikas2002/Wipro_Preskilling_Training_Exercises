import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex8TaskList } from './ex8-task-list';

describe('Ex8TaskList', () => {
  let component: Ex8TaskList;
  let fixture: ComponentFixture<Ex8TaskList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex8TaskList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex8TaskList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
