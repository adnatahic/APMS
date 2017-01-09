import { Component, OnInit } from '@angular/core';

import { Node } from '../node';
import { NodeService } from '../node-service';
import { MessageService } from '../message-service';

declare var google: any;
declare var window: any;
@Component({
    selector: 'map',
    styleUrls: ['app/menu/maps.style.css'],
    templateUrl: 'app/menu/menu.component.html'
})
export class MenuComponent implements OnInit {
    nodes: Node[];
    map: any;
    markers: any[] = [];
    //infoWindows: any[] = [];

    constructor(private _nodeService: NodeService, private _messageService: MessageService) { 
       setInterval(() => { this.getNodes(); }, 5000);
    }

    ngOnInit(): void {
        this.map = new google.maps.Map(document.getElementById('map'), {
            zoom: 13,
            center:  { lat: 43.851852, lng: 18.380592 }  
        });
    }

    getNodes() {
        let ne = this.map.getBounds().getNorthEast();
        let sw = this.map.getBounds().getSouthWest();

        this._nodeService.getNodes(ne.lat(), ne.lng(), sw.lat(), sw.lng())
        .subscribe((nodes) => {
          if(this.markers.length != 0) {
                for (var i = 0; i < this.markers.length; i++) {
                    if(nodes.findIndex(x => x.id == parseInt(this.markers[i].getTitle())) == -1) {
                        this.markers[i].setMap(null);
                      /*  for(var j = 0; j < this.infoWindows.length; j++) {
                            if(parseInt(this.infoWindows[j][1]) == parseInt(this.markers[i].getTitle())) {
                                console.log("Obrisano " + this.infoWindows[j][1]);
                                this.infoWindows[j][1] = "";
                                break;
                            }
                        }*/
                        this.markers[i].setTitle("");
                     }
                }
            }
      
            this.nodes = nodes;
            for (let node of this.nodes) {
                let novi = false;
               if (this.markers.findIndex(x => parseInt(x.getTitle()) == node.id) == -1) {
                   let marker = new google.maps.Marker( {
                    position: { lat: node["currentLat"], lng: node["currentLng"] },
                    map: this.map,
                    title: node.id.toString()
                });
                this.markers.push(marker);
                novi = true;

               // this.infoWindows.push([infowindow, marker.getTitle()]);
               // console.log(this.infoWindows);
               } 
               
               let marker = this.markers.find(x => parseInt(x.getTitle()) == node.id); 

               this._messageService.getLatestMessage(node["id"])
                .subscribe((message) => {
                    
                    var info = "IP: " + message.gatewayIP + " via " + message.protocol + "<br>";
                    info += "<h4>" + node.name + " @ " + (new Date(message.creationTime)).toUTCString() + "</h4>";
                    for (var measure of message.measurements) {
                        info += measure.measureName + ": " + measure.value.toPrecision(4) + " " + measure.unitCode + "<br>";
                    }

                    if (novi) {
                    var infowindow = new google.maps.InfoWindow({
                        content: info
                    });
                
                    marker.addListener('click', function() {
                    infowindow.open(this.map, marker);
                    });
                    } else {
                        google.maps.event.clearListeners(marker, 'click');
                        var infowindow = new google.maps.InfoWindow({
                        content: info
                    });
                
                    marker.addListener('click', function() {
                    infowindow.open(this.map, marker);
                    });
                    }
                    /*
                    for(var inf of this.infoWindows) {
                        if(parseInt(inf[1]) == parseInt(marker.getTitle())) {
                            inf[0].setContent(info);
                            break;
                        }
                    }*/
                });
                
            }
        });
    }

}