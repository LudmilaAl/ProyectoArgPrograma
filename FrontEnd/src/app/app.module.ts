import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercaComponent } from './components/acerca/acerca.component';
import { ExplaboralComponent } from './components/explaboral/explaboral.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { SkillsComponent } from './components/skills/skills.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { MarcaComponent } from './components/marca/marca.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InterceptorProvider } from './service/interceptor-service';
import { NewExpComponent } from './components/explaboral/new-exp.component';
import { EditexpComponent } from './components/explaboral/editexp.component';
import { NewUserComponent } from './components/login/new-user.component';
import { NewStudiesComponent } from './components/educacion/new-studies.component';
import { EditStudiesComponent } from './components/educacion/edit-studies.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BannerComponent,
    AcercaComponent,
    ExplaboralComponent,
    EducacionComponent,
    SkillsComponent,
    ProyectosComponent,
    MarcaComponent,
    HomeComponent,
    LoginComponent,
    NewExpComponent,
    EditexpComponent,
    NewUserComponent,
    NewStudiesComponent,
    EditStudiesComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    DragDropModule


  ],
  providers: [
    InterceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
