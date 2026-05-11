import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  private authService = inject(AuthService);
  private router = inject(Router);

  username = '';
  password = '';
  errorMessage = '';

  login(): void {
    this.authService.login({
      username: this.username,
      password: this.password
    }).subscribe({
      next: response => {
        this.authService.saveToken(response.accessToken);
        this.router.navigate(['/clients']);
      },
      error: () => {
        this.errorMessage = 'Username ou mot de passe incorrect';
      }
    });
  }
}
