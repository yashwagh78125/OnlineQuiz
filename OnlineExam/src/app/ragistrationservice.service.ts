import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class RagistrationserviceService {

  constructor(private HttpClient:HttpClient) { }
   
  saveData(user:User)
  {
    return this.HttpClient.post<boolean>("http://localhost:9090/saveUser",user);
  }


}

export class  User
{
  username:string;
  password:string;
  mobno:number;
  emailid:string;

  constructor(username:string,password:string,mobno:number,emailid:string)
  {
    this.username=username;
    this.password=password;
    this.mobno=mobno;
    this.emailid=emailid;
  }
}
