import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizserviceService {
  constructor(private httpclient:HttpClient) { }

  getFirstQuestion(subject:string)
  {
      return this.httpclient.get<Question>("http://localhost:9090/getFirstQuestion/"+subject);
  }

  nextQuestion(answer:Answer)
  {
    return this.httpclient.post<Question>("http://localhost:9090/next/",answer);
  }

  previousQuestion(answer:Answer)
  {
    return this.httpclient.post<Question>("http://localhost:9090/previous/",answer);
  }

  endexam()
  {
    return this.httpclient.get<number>("http://localhost:9090/endexam");
  }

  getAllAnswers()
  {
    return this.httpclient.get<Answer[]>("http://localhost:9090/allAnswers");
  }
  

  saveScore(Score:score)
  {
    return this.httpclient.post<boolean>("http://localhost:9090/saveScore/",Score);
  }


  
}


export class Question
{
  qno:number;
	subject:string;
  qtext:string;
  op1:string;
  op2:string;
  op3:string;
  op4:string;
  answer:string;

   constructor(qno:number,subject:string,qtext:string,op1:string,op2:string,op3:string,op4:string,answer:string)
   {
    this.qno=qno;
    this.answer=answer;
    this.op1=op1;
    this.op2=op2;
    this.op3=op3;
    this.op4=op4;
    this.answer=answer;
    this.subject=subject;
    this.qtext=qtext;
   }
   
}


export class Answer
{
  qno:number;
	submittedAnswer:string;
  qtext:string;
  originalAnswer:string;
  
  constructor(qno:number,qtext:string,submittedAnswer:string,originalAnswer:string)
  {
      this.qno=qno;
      this.originalAnswer=originalAnswer;
      this.submittedAnswer=submittedAnswer;
      this.qtext=qtext;
  }
    
}

export class score
{
   constructor(public id:number,public score:number)
   {

   }
}