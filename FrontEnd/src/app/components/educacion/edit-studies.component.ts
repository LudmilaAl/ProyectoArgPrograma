import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Studies } from 'src/app/model/studies';
import { StudiesService } from 'src/app/service/studies.service';

@Component({
  selector: 'app-edit-studies',
  templateUrl: './edit-studies.component.html',
  styleUrls: ['./edit-studies.component.css']
})
export class EditStudiesComponent implements OnInit {
  studies: Studies = null;
  constructor(private studiesService: StudiesService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.studiesService.detail(id).subscribe(data =>{
      this.studies = data;
    }, err =>{
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    })
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.studiesService.update(id, this.studies).subscribe(data =>{
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar la experiencia");
      this.router.navigate(['']);
    })
  }

}
