import { Component } from '@angular/core'

@Component({
    templateUrl: 'app/input/input.component.html'
})
export class InputComponent {
    creationTime: Date;
    data: string;
    lat: string;
    lng: string;
    gatewayIp: string;

    createMessage() {
        
    }
}