import { Component } from '@angular/core';
import { EncodedMessage } from '../encoded-message';

import { LocationService } from './location.service';

@Component({
    selector: 'menu',
    templateUrl: 'app/menu/menu.component.html'
})
export class MenuComponent{
    locations: EncodedMessage[] = [];
    
    constructor(private _locationService: LocationService) {
    }
    getLocations(): void {
        this._locationService.getLocations()
        .subscribe((locations) => { this.locations = locations; 
                                    console.log(this.locations); } );
    }

}