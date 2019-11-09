import { MatchFormat } from "./match-format.enum";
import { Player } from "./player";

export class Team{
    constructor(public teamId:number,
    public teamName:string,
    public ranking:number,
    public players:Player[],
    public format:MatchFormat,
    public leagues:string) {}
}