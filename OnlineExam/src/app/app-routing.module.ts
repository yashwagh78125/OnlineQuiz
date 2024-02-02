import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RagistrationComponent } from './ragistration/ragistration.component';
import { QuizComponent } from './quiz/quiz.component';
import { ScoreComponent } from './score/score.component';

const routes: Routes = 
[
  {path:"showlogin",component:LoginComponent},
  {path:"savedata",component:RagistrationComponent},
  {path:"showquiz",component:QuizComponent},
  {path:"score",component:ScoreComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
