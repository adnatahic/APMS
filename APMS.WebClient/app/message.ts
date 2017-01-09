import { Measure } from './measure';

export interface Message {
    id: number;
    creationTime: Date;
    lat: number;
    lng: number;
    gatewayIP: string;
    protocol: string;
    measurements: Measure[];
}