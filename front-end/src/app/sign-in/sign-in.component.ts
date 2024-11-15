import { Component } from '@angular/core';
import {IUserCredentials} from '../../entity/user-model';
import {FormsModule} from '@angular/forms';
import {UserService} from '../user.service';
import {Router} from '@angular/router';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css'
})
export class SignInComponent {

  credentials: IUserCredentials = {username: '', password: ''};
  signInError: boolean = false;
  constructor(private userService : UserService, private router: Router) {
  }

  signIn(){
    this.userService.signIn(this.credentials).subscribe({
      //next: () => this.router.navigate(['/po logowaniui']),
      //to metoda nawigacji po submitcie po wykonaniu metody
      error: () => (this.signInError = true),
    })
  }
}
