import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Task } from '../task';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ex8-task-list',
  imports: [CommonModule],
  templateUrl: './ex8-task-list.html',
  styleUrl: './ex8-task-list.css'
})
export class Ex8TaskList {
  @Input() tasks: Task[] = [];
  @Output() taskDeleted = new EventEmitter<number>();
  deleteMessage: string='';

  deleteTask(id: number) {
    this.taskDeleted.emit(id);
     this.deleteMessage = `Task with ID ${id} is deleted.`;
  }
}
