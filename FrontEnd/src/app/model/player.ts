import { Team } from "./team";
import { RoleType } from "./role-type.enum";

export class Player {
    constructor(
    public playerId: number,
    public name: string,
    public teams: Team[],
    public age: number,
    public nationality: string,
    public rating: number,
    public runs: number,
    public wickets: number,
    public roleType: RoleType,
    ){}
}