import { Component } from '@angular/core';
import { Task } from '../task';
import { Ex8Task } from '../ex8-task/ex8-task';
import { Ex8TaskList } from '../ex8-task-list/ex8-task-list';

@Component({
  selector: 'app-ex8-home',
  imports: [Ex8Task, Ex8TaskList],
  templateUrl: './ex8-home.html',
  styleUrl: './ex8-home.css'
})
export class Ex8Home {
  tasks: Task[] = [];

  // function to add new task
  addTask(task: Task) {
    this.tasks.push(task);
  }

  // function to delete task
  deleteTask(id: number) {
    this.tasks = this.tasks.filter(task => task.id !== id);
  }
}
