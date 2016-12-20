import { Component, OnInit } from '@angular/core';
declare var google: any;

@Component({
    moduleId: module.id,
    selector: 'maps',
    template: '<div id="map">map</div>',
    styleUrls: ['maps.style.css']
})
export class MapsComponent implements OnInit {
    map: any;
    point: any;

    ngOnInit(): void {
        this.point = { lat: 43.8523, lng: 18.3861 };    
        this.map = new google.maps.Map(document.getElementById('map'), {
            zoom: 25,
            center: this.point
        });
    }
}