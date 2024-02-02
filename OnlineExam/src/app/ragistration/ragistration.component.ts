import { Component } from '@angular/core';
import { RagistrationserviceService, User } from '../ragistrationservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ragistration',
  templateUrl: './ragistration.component.html',
  styleUrls: ['./ragistration.component.css'],
})
export class RagistrationComponent
 {
  constructor(private rgservice:RagistrationserviceService,private route:Router){}
  ngRagister()
  {
    this.route.navigateByUrl("/savedata");
  }
  user:User=new User("","",0,"");
  msg:string='';
  isDone:boolean=false;
  notDone:boolean=false;
  saveData()
  {
       this.rgservice.saveData(this.user).subscribe(()=>
        {
          
           if(this.msg="Ragistration Successfull")
           {
               
               this.isDone=true;
               this.route.navigateByUrl("showlogin")
           }
        },()=>
        {
           this.msg="User Already Ragistered"
        });
  }   

}
