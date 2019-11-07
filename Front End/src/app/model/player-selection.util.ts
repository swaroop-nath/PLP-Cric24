import { Player } from './player.model';

export class PlayerSelection {
    constructor(
        public player: Player = null,
        public isChecked: boolean = false
    ) {}
}