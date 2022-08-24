import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Workexp } from 'src/app/model/workexp';
import { WorkexpService } from 'src/app/service/workexp.service';

@Component({
  selector: 'app-editexp',
  templateUrl: './editexp.component.html',
  styleUrls: ['./editexp.component.css']
})
export class EditexpComponent implements OnInit {
  workExp: Workexp = null;
  constructor(private workexpService: WorkexpService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.workexpService.detail(id).subscribe(data =>{
      this.workExp = data;
    }, err =>{
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.workexpService.update(id, this.workExp).subscribe(data =>{
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    })
  }


}
