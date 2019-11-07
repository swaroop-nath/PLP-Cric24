import { Team } from './team.model';

export class TeamSelection {
    constructor(
        public team: Team = null,
        public isChecked: boolean = false
        ){}
}