import { Donacija } from './donacija.model';

export interface KorisnikInterface {
    id?: number;
    username?: string;
    password?: string;
    firstName?: string;
    lastName?: string;
    donacije?:Donacija[];
}