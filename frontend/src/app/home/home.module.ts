import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { RouterModule } from '@angular/router'
import { FormGroup, FormControl, FormBuilder, Validators, FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormGroup,
    FormControl,
    FormBuilder,
    Validators,
    FormsModule
  ],
  declarations: [HomeComponent]
})
export class HomeModule { }
