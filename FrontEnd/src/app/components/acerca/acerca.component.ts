import { Component, OnInit } from '@angular/core';
import { person } from 'src/app/model/person.model';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-acerca',
  templateUrl: './acerca.component.html',
  styleUrls: ['./acerca.component.css']
})
export class AcercaComponent implements OnInit {
  person: person = new person("","","")
  
  constructor(public personService: PersonService) { }

  ngOnInit(): void {
    this.personService.getPerson().subscribe(data => {this.person = data})
  }

}
