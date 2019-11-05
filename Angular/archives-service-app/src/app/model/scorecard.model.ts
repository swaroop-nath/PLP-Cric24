import { Player } from "./player.model";

export class ScoreCard{
    constructor(
        public scoreCardID : number = 0,
        public teamOne : Team = null,
        public teamTwo : Team = null,
        public teamOneScore : number = 0,
        public teamOneWickets : number = 0,
        public teamOneOvers : number = 0,
        public teamTwoScore : number = 0,
        public teamTwoWickets : number = 0,
        public teamTwoOvers : number = 0,
        public playerOfTheMatch : Player = null
    ){}
}