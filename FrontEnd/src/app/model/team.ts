import { MatchFormat } from "./match-format.enum";
import { Player } from "./player";

export class Team {constructor(
public teamId:number=0,
public teamName:string='',
public ranking:number=null,
public players:Player[]=null,
public format:MatchFormat=null,
public leagues:string='',
){}

}