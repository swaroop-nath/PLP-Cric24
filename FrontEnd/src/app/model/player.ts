import { RoleType } from "./role-type.enum";
import { Team } from "./team";

export class Player{
    constructor (
    public playerId:number = 0,
    public name:string='',
    public teams:Team[] = null,
    public age:number = 0,
    public nationality:string = '',
    public rating:number = 0,
    public runs:number = 0,
    public wickets:number = 0,
    public roleType:RoleType = null
    ){}
}