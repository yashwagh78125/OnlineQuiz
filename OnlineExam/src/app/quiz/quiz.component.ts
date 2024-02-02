import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Answer, Question, QuizserviceService } from '../quizservice.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  username:any;
  subject:any;
  question:Question=new Question(0,'','','','','','','');
  submittedAnswer:string='';
  answer:Answer=new Answer(0,'','','');
  remainingTime=180;
  durationMessage:string="";
  previousAnswer:any="";
  examInterval:any;  
  selected=false;
  totalscore:any;
  color:string=""
  constructor(private questionService:QuizserviceService,private router:Router) 
  { 
    this.username=sessionStorage.getItem('username');
    this.subject=sessionStorage.getItem('subject');
  }
  quizNav()
  {
     this.router.navigateByUrl("/quizpage");
  }

  ngOnInit()
  {
    this.examInterval=setInterval(()=>{
       this.remainingTime=this.remainingTime-1;
       const min=Math.floor(this.remainingTime/60);
       const sec=this.remainingTime%60;
       this.durationMessage="The Remainning time "+min+":"+sec;
         if(this.remainingTime==0)
         {
            this.endexam();
         }
         if(this.remainingTime==60)
         {
           this.color="red";
         }
       
      },1000);
  
    this.questionService.getFirstQuestion(this.subject).subscribe(question=>this.question=question);

  }

  nextQuestion()
  {
    this.answer.submittedAnswer=this.submittedAnswer;
    this.answer.qno=this.question.qno;
    this.answer.qtext=this.question.qtext;
    this.answer.originalAnswer=this.question.answer;
    this.questionService.nextQuestion(this.answer).subscribe(question=>this.question=question);
  
  }

  previousQuestion()
  {
    this.selected=false;
    this.answer.submittedAnswer=this.submittedAnswer;
    this.answer.qno=this.question.qno;
    this.answer.qtext=this.question.qtext;
    this.answer.originalAnswer=this.question.answer;
    
    this.questionService.previousQuestion(this.answer).subscribe(question=>this.question=question);
  }

  

  endexam()
  {
    this.questionService.endexam().subscribe(totalscore=>{this.totalscore=totalscore;console.log('score from service is '+this.totalscore);let temp=this.totalscore+"";

    console.log("value in session storage is " + temp);
    
    sessionStorage.setItem("totalscore",temp);

    this.router.navigate(['score']);
   });


  }

  }
  


    
   


