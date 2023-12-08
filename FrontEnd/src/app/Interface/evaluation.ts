import { Restaurant } from "./restaurant"

export interface Evaluation {
    id : number
    nom : string
    texte : string
    note : number
    date_creation : string
    date_MAJ : string
    restaurant? : Restaurant
}
