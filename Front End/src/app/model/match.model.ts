import { ScoreCard } from "./scorecard.model";
import { MatchFormat } from "./match-format.enum";
import { Stadium } from './stadium.model';
import { Team } from './team.model';
import { MatchStatus } from './match-status.enum';

export class Match {
    constructor(
        public matchID : number = 0 ,
        public matchSchedule : Date = null,
        public matchVenue : Stadium = null,
        public matchFormat : MatchFormat = null,
        public teamOne : Team = null,
        public teamTwo : Team = null,
        public matchLeague : String = '',
        public matchScoreCard : ScoreCard = null,
        public matchStatus : MatchStatus = null,
        public winningTeam : Team = null
    ){}
}