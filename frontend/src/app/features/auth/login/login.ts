import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { RouterModule } from '@angular/router';

import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    MatCardModule,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule
  ],
  templateUrl: './login.html',
  styleUrls: ['./login.scss']
})
export class LoginComponent {

  hidePassword = true;
loginForm!: FormGroup;


loading = false;

submitted = false;
constructor(
    private fb: FormBuilder
) {
    this.initializeForm();
}

private initializeForm(): void {

    this.loginForm = this.fb.group({

        email: [

            '',

            [

                Validators.required,

                Validators.email

            ]

        ],

        password: [

            '',

            [

                Validators.required,

                Validators.minLength(8),

                Validators.maxLength(30)

            ]

        ],

        rememberMe: [

            false

        ]

    });

}
get formControls() {

    return this.loginForm.controls;

}
  togglePassword(): void {
    this.hidePassword = !this.hidePassword;
  }
  onSubmit(): void {

    this.submitted = true;

    if (this.loginForm.invalid) {

        this.loginForm.markAllAsTouched();

        return;

    }

    this.loading = true;

    console.log(this.loginForm.value);

}
resetForm(): void {

    this.loginForm.reset({

        rememberMe: false

    });

    this.submitted = false;

}

}