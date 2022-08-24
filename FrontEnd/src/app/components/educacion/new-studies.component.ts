import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Studies } from 'src/app/model/studies';
import { StudiesService } from 'src/app/service/studies.service';

@Component({
  selector: 'app-new-studies',
  templateUrl: './new-studies.component.html',
  styleUrls: ['./new-studies.component.css']
})
export class NewStudiesComponent implements OnInit {
  degreeS : string = '';
  dateS : string = '';
  institutionS : string = '';

  constructor(private studiesService: StudiesService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const studies = new Studies(this.degreeS, this.dateS, this.institutionS);
    this.studiesService.save(studies).subscribe(data => {
        alert("Estudios añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }

}
