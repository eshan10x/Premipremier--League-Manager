export interface IService {
    clubName: string;
    clubLocation: string;
    points: number;
    clubId: number;
    numOfWins: number;
    numOfDefeats: number;
    numOfDraws: number;
    numOfGoalsReceived: number;
    numOfGoalsScored: number;
    numOfMatches: number;
    goalDiffer: number;
}

export interface Imatch {
    Date: any;
    team1: string;
    team2: string;
    team1Goals: number;
    team2Goals: number;
    matchStadium: string;
    date: Date;
}

