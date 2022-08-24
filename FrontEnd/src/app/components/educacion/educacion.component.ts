import { Component, OnInit } from '@angular/core';
import { Studies } from 'src/app/model/studies';
import { StudiesService } from 'src/app/service/studies.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  studies: Studies[] = [];
  constructor(private studiesService: StudiesService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadStudies();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadStudies(): void{
    this.studiesService.list().subscribe(data => {this.studies = data;})
  }

  delete(id?: number){
    if(id !=undefined){
      this.studiesService.delete(id).subscribe(data =>{
        this.loadStudies();
      }, err => {
        alert("No se pudo borrar");
      } )
    }
  }

}
