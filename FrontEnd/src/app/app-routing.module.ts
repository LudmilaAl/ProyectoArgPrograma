import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditStudiesComponent } from './components/educacion/edit-studies.component';
import { NewStudiesComponent } from './components/educacion/new-studies.component';
import { EditexpComponent } from './components/explaboral/editexp.component';
import { NewExpComponent } from './components/explaboral/new-exp.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NewUserComponent } from './components/login/new-user.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'newexp', component: NewExpComponent},
  {path:'editexp/:id', component: EditexpComponent},
  {path:'newUser', component: NewUserComponent}, 
  {path:'newstudies', component: NewStudiesComponent},
  {path:'editstudies/:id', component: EditStudiesComponent},  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
