export interface EncodedMessage {
    id: number;
    creationTime: Date;
    lat: number;
    lng: number;
    nodeId: string;
    gatewayIP: string;
    encodedData: string;
    messageId: number;
}