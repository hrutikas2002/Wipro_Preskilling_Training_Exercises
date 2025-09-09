import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserServices } from '../../services/user';
import { Iuser } from '../../interfaces/iuser';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})

export class Register {
  user: Iuser = {
    firstName: '',
    lastName: '',
    emailId: '',
    userId: '',
    passWord: '',
    address: '',
    userType: 1
  };

  constructor(private userService: UserServices) {}

  onRegister() {
    this.userService.register(this.user).subscribe({
      next: (res) => {
        alert('User Registered Successfully!');
        this.user = { firstName: '', lastName: '', emailId: '', userId: '', passWord: '', address: '', userType: 0 };
      },
      error: (err) => {
        console.error(err);
        alert('Registration failed. Please try again.');
      }
    });
  }
}

