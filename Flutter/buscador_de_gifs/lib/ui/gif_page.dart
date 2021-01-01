import 'package:flutter/material.dart';
import 'package:share/share.dart';

class GifPage extends StatelessWidget {
  final Map _gifData;

  GifPage(this._gifData); //construtor

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: Text(_gifData["title"], style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.black,
        actions: [
          IconButton(icon:
              Icon(Icons.share, color: Colors.white,),
              onPressed: () {
                Share.share(_gifData["images"]["fixed_height"]["url"]);
              })
        ],
      ),

      body: Center(
        child: Image.network(_gifData["images"]["fixed_height"]["url"]),
      ),
    );
  }
}
