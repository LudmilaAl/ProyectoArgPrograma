import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Workexp } from 'src/app/model/workexp';
import { WorkexpService } from 'src/app/service/workexp.service';

@Component({
  selector: 'app-new-exp',
  templateUrl: './new-exp.component.html',
  styleUrls: ['./new-exp.component.css']
})
export class NewExpComponent implements OnInit {
  nameExp: string = '';
  descriptionExp: string = '';
  dateExp: string = '';

  constructor(private workexpService: WorkexpService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const exp = new Workexp(this.nameExp, this.descriptionExp, this.dateExp);
    this.workexpService.save(exp).subscribe(data => {
        alert("Experiencia añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }

}
