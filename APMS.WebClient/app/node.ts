import { Message } from './message';

export interface Node {
    id: number;
    name: string;
    currentLat: number;
    currentLng: number;
    messages: Message[];
    //IOBlocks: IOBlock[];
}