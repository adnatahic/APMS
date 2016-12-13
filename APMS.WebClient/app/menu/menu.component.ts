import { Component } from '@angular/core';
import { Location } from '../Location';

import { LocationService } from './location.service';

@Component({
    selector: 'menu',
    templateUrl: 'app/menu/menu.component.html'
})
export class MenuComponent{
    locations: any[] = [];
    
    constructor(private _locationService: LocationService) {
    }
    getLocations(): void {
        this._locationService.getLocations()
        .subscribe((locations) => {
            this.locations;
            console.log(this.locations);
            }
            );
    }

}