export interface SecurityUserInterface{
    id?:number;
    firstName?:string;
    lastName?:string;
    username?:string;
    password?:string;
    roles?:string[];

}

export class User implements SecurityUserInterface{
    id:number;
    firstName:string;
    lastName:string;
    username:string;
    password:string;
   


    constructor(ucf:SecurityUserInterface){
        this.id=ucf.id;
        this.firstName=ucf.firstName;
        this.lastName=ucf.lastName;
        this.username=ucf.username;
        this.password=ucf.password;
       
    }

}