export class Workexp {
    id? : number;
    nameExp : string;
    descriptionExp : string;
    dateExp : string;

    constructor(nameExp: string, descriptionExp: string, dateExp: string){
        this.nameExp = nameExp;
        this.descriptionExp = descriptionExp;
        this.dateExp = dateExp;
    }
}
