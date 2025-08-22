import { Component, EventEmitter, Output } from '@angular/core';
import { Task } from '../task';
import { FormsModule, NgModel } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ex8-task',
  imports: [FormsModule, CommonModule],
  templateUrl: './ex8-task.html',
  styleUrl: './ex8-task.css',
})
export class Ex8Task {
  description: string = '';
  category: string = 'Work'; // default
  static idCounter = 1; // static counter for unique ids
  addMessage: string = '';

  @Output() taskAdded = new EventEmitter<Task>();

  addTask() {
    if (this.description.trim() === '') return;

    const newTask: Task = {
      id: Ex8Task.idCounter++,
      description: this.description,
      category: this.category,
    };

    this.taskAdded.emit(newTask);
    
    this.addMessage = `Task with ID ${newTask.id} is added in table.`;

    // reset fields
    this.description = '';
    this.category = 'Work';
  }
}
