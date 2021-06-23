import { Component, OnInit } from '@angular/core';
import {CameraOptions, Camera } from '@ionic-native/camera/ngx';

@Component({
  selector: 'app-camera',
  templateUrl: './camera.page.html',
  styleUrls: ['./camera.page.scss'],
})
export class CameraPage implements OnInit {

  foto : any;
  constructor(private camera: Camera) { }

  ngOnInit() {
  }

  async tirarFoto() {
    const options: CameraOptions = {
      quality: 100,
      destinationType: this.camera.DestinationType.DATA_URL,
      encodingType: this.camera.EncodingType.JPEG,
      mediaType: this.camera.MediaType.PICTURE
    };

    this.camera.getPicture(options).then((imageData) => {
      let base64Image = 'data:image/jpegbase64,' + imageData;

      this.foto = base64Image;
    }, (err) => {
      alert('Não foi possivel tirar a foto!');
      alert(err);
    });

  }
}
