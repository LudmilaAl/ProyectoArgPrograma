import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUser } from 'src/app/model/login-user';
import { AuthService } from 'src/app/service/auth.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  isLogged = false;
  isLoginFail = false;
  loginUser!: LoginUser;
  username!: string;
  password!: string;
  roles: string [] = [];
  erroMsj!: string;

  constructor(private tokenService : TokenService, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
      this.isLoginFail = false;
      this.roles = this.tokenService.getAuthorities();
    }
  }

  onLogin(): void{

    this.loginUser = new LoginUser(this.username, this.password); 
    this.authService.login(this.loginUser).subscribe(data => {
      this.isLogged = true;
      this.isLoginFail =false;
      this.tokenService.setToken(data.token);
      this.tokenService.setUsername(data.username);
      this.tokenService.setAuthorities(data.authorities);
      this.router.navigate([''])
    }, err =>{
      this.isLogged = false;
      this.isLoginFail = true;
      this.erroMsj = err.error.mensaje;
      console.log(this.erroMsj);
    })

  }

}
