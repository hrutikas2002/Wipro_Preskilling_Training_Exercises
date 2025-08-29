import { Component } from '@angular/core';
import { UserServices } from '../../services/user';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {
  showHeader = true;
  username: string | null = null;

  constructor(private userService: UserServices, private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        const hiddenRoutes = ['/', '/login', '/register'];
        this.showHeader = !hiddenRoutes.includes(this.router.url);

        // Get username only when header is visible
        if (this.showHeader) {
          this.username = this.userService.getUserId();
        }
      }
    });
  }

  logout() {
    this.userService.logout();
    this.router.navigate(['/login']);
  }
}
