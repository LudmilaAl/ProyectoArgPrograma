import { Component, OnInit } from '@angular/core';
import { Workexp } from 'src/app/model/workexp';
import { TokenService } from 'src/app/service/token.service';
import { WorkexpService } from 'src/app/service/workexp.service';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-explaboral',
  templateUrl: './explaboral.component.html',
  styleUrls: ['./explaboral.component.css']
})
export class ExplaboralComponent implements OnInit {
  
  
  
  
  
  
  
  experience: Workexp[] = [];

  constructor(private workexpService: WorkexpService, private tokenService: TokenService) { }

  isLogged = false;


  ngOnInit(): void {
    this.loadExperience();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadExperience(): void{
    this.workexpService.list().subscribe(data => {this.experience = data;})
  }

  delete(id?: number){
    if(id !=undefined){
      this.workexpService.delete(id).subscribe(data =>{
        this.loadExperience();
      }, err => {
        alert("No se pudo borrar");
      } )
    }
  }




  

}
