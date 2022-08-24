export class Studies {
    id? : number;
    degreeS : string;
    dateS : string;
    institutionS : string;

    constructor(degreeS: string, dateS: string, institutionS: string){
        this.degreeS = degreeS;
        this.dateS = dateS;
        this.institutionS = institutionS;
    }
}
