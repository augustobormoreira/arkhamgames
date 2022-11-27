import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { UserDTO } from '../../modelDTO/UserDTO';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  isUserLoggedIn(){
    return !!localStorage.getItem('token');
  }

  login(username: String | any, password: String | any){
    let tempUser: UserDTO = new UserDTO(
      username,
      password
    )
    return this.httpClient.post(`${environment.API_URL}/users/findUser`, tempUser).pipe(
      tap((response: any) => {
        localStorage.setItem('user_auth', response.clientUsername);
      })
    );
  } 
}
