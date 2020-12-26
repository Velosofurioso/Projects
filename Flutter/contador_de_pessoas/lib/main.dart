import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
      title: "Contador de Pessoas",
      home: Home()));
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {

  int _people = 0;
  String _infoText = "Pode entrar";

  void _changePeople(int delta){
    setState(() {
      _people += delta;

      if(_people < 0)
        _infoText = "Mundo Invertido?";

      else if(_people <= 10)
        _infoText = "Pode Entrar";

      else
        _infoText = "Lotado";
    });
  }

  @override
  Widget build(BuildContext context) {
    return Stack(

      children: [
        Image.asset(
          "images/restaurant.jpg",
          fit: BoxFit.cover,
          height: 1000.0,
        ),

        Column(

          mainAxisAlignment: MainAxisAlignment.center,
          // Alinha o conteudo da coluna no centro da tela

          children: [
            Text(
              "Pessoas: $_people",
              style:
              TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
            ),

            Row(mainAxisAlignment: MainAxisAlignment.center, children: [

              Padding(
                  padding: EdgeInsets.all(10.0),
                  child: FlatButton(
                      onPressed: () {_changePeople(1);},
                      child: Text(
                        "+1",
                        style: TextStyle(fontSize: 40.0, color: Colors.white),
                      ))),

              Padding(
                  padding: EdgeInsets.all(10.0),
                  child: FlatButton(
                      onPressed: () {_changePeople(-1);},
                      child: Text(
                        "-1",
                        style: TextStyle(fontSize: 40.0, color: Colors.white),
                      ))),
            ]),

            Text(
              _infoText,
              style: TextStyle(
                  color: Colors.white,
                  fontSize: 30.0,
                  fontStyle: FontStyle.italic),
            ),
          ],
        )
      ],
    );
  }
}
