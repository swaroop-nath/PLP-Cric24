import { Player } from "./player.model";
import { MatchFormat } from "./match-format.enum";

export class Team {
    constructor(
        public teamId : number = 0,
        public teamName : string = '',
        public ranking : number = 0,
        public leagues : string = '',
        public players : Player[] = null,
        public format : MatchFormat = null
    ){}
}