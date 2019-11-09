import { User } from './user.model';

export class Blog{
    constructor(public blogId:number=null,
        public blogType:string="",
        public blogHeading:string ="",
        public blogContent:string="",
        public status:string="",
        public blogger: User=null)
        {}
}