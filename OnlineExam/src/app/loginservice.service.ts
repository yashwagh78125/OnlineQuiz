import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './ragistrationservice.service';
@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private HttpClient:HttpClient) { }
  getUser(username:string)
  {
     return this.HttpClient.get<User>("http://localhost:9090/getUser/"+username);
  }
  

}
