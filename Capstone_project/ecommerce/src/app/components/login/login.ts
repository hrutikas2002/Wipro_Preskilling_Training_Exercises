import { Component } from '@angular/core';
import { DecodedToken } from '../../interfaces/decoded-token';
import { Token } from '../../interfaces/token';
import { UserServices } from '../../services/user';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  credentials = { userId: '', passWord: '' };

  constructor(private userService: UserServices, private router: Router) {}

  onLogin() {
    this.userService.login(this.credentials).subscribe({
      next: (res: Token) => {

        console.log("JWT Token:", res.token);
        this.userService.saveToken(res.token);


        // Decode the token
        const decoded = this.userService.decodeToken();

        if (decoded) {
          if (decoded.role === "ROLE_ADMIN") {
            this.router.navigate(['/admin-dashboard']);
          } else {
            this.router.navigate(['/user-dashboard']);
          }
        } else {
          this.router.navigate(['/login']); // fallback if decode fails
        }
      },
      error: () => alert('Login Failed!')
    });
  }
}
