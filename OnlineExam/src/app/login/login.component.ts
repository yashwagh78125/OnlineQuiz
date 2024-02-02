import { Component } from '@angular/core';
import { User } from '../ragistrationservice.service';
import { LoginserviceService } from '../loginservice.service';
import { Route, Router } from '@angular/router';
import { QuizComponent } from '../quiz/quiz.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent
 {
  user:User=new User("","",0,"");
  msg1:string='';
  msg2:string='';
  subject:string="";
  constructor(private loginser:LoginserviceService,private router:Router){}
  ngLogin()
  {
    this.router.navigateByUrl("/showlogin");
  }

  
  getData()
  {
     this.loginser.getUser(this.user.username).subscribe(p=>
      {
       if(this.user.password==p.password && this.user.username==p.username)
       {
          sessionStorage.setItem("username",this.user.username);
          sessionStorage.setItem("subject",this.subject);
          this.router.navigateByUrl("showquiz");
          
       }  
       else
       {
        this.msg2="Invalid Password"
       }   
      },error=>
      {
          this.msg1="Invalid Username "     
      });
  }

 }

