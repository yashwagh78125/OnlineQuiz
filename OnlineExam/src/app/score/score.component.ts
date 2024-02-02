import { Component, OnInit } from '@angular/core';
import { Answer, QuizserviceService, score } from '../quizservice.service';
import { QuizComponent } from '../quiz/quiz.component';


@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent implements OnInit
{

  green:string='green';
  color:string="";
  totalscore:any;
  allanswers:Answer[]=[];
  scor:score=new score(0,0);
 
  constructor(private quizService:QuizserviceService) 
  { 
    this.totalscore=sessionStorage.getItem('totalscore');
    console.log("score from component is " + this.totalscore);

  }

  

  savescore()
  {
    this.scor=this.totalscore;
    this.quizService.saveScore(this.scor).subscribe(response=>{});
    this.savescore();
  }
  ngOnInit() 
  {
    
    
    this.quizService.getAllAnswers().subscribe(response=>{
      this.allanswers=response
    if(this.allanswers.filter(p=>p.submittedAnswer.includes(p.originalAnswer)))
    {  
       return this.color="green"
    }
    else
    {
     
     return this.color="red"

    }
  
  
  
  });
  }    
  
  getcolor(subcolor:string,oricolor:string)
  {
       if(subcolor==oricolor)
       {
        return "green";
       }
       else
       {
        return "red";
       }
  }


  


}