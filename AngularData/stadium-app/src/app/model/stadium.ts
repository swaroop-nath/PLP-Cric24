export class StadiumModel{
    constructor(
        public stadiumId: number = null,
        public stadiumName: string = '',
        public location: string = '',
        public country: string = '',
        public capacity: number = null,
        public stadiumImage: string = null
        ) {}
}