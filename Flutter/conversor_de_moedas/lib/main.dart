import "package:flutter/material.dart";
import "package:http/http.dart" as http;
import "dart:async";
import "dart:convert";

const request = "https://api.hgbrasil.com/finance?format=json&key=5e5965b0";

void main() async {

  runApp(MaterialApp(
   home: Home(),
    theme: ThemeData(
      hintColor: Colors.amber,
      primaryColor: Colors.white,
      inputDecorationTheme: InputDecorationTheme(
        enabledBorder:
          OutlineInputBorder(borderSide:  BorderSide(color: Colors.amber)),
        focusedBorder:
          OutlineInputBorder(borderSide: BorderSide(color: Colors.white)),
        hintStyle: TextStyle(color: Colors.amber),
      )
    ),
  ));
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {

  final realControler = TextEditingController();
  final dolarControler = TextEditingController();
  final jpyControler = TextEditingController();

  double dolar;
  double jpy;

  void _realChange(String text){
    if(text.isEmpty){
      _clearAll();
      return;
    }
    double real = double.parse(text);
    dolarControler.text = (real / dolar).toStringAsFixed(2);
    jpyControler.text =  (real / jpy).toStringAsFixed(2);
  }

  void _dolarChange(String text){
    if(text.isEmpty){
      _clearAll();
      return;
    }
    double dolar = double.parse(text);
    realControler.text = (dolar * this.dolar).toStringAsFixed(2);
    jpyControler.text =  (dolar * this.dolar / jpy).toStringAsFixed(2);
  }

  void _jpyChange(String text){
    if(text.isEmpty){
      _clearAll();
      return;
    }
    double jpy = double.parse(text);
    realControler.text =  (jpy * this.jpy).toStringAsFixed(2);
    dolarControler.text = (jpy * this.jpy / dolar).toStringAsFixed(2);
  }

  void _clearAll(){
    realControler.text = "";
    dolarControler.text = "";
    jpyControler.text = "";
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(  // Widget para colocar a barra superior
      backgroundColor: Colors.black,
      appBar: AppBar(
        title: Text("\$ Conversor \$"),
        centerTitle: true,
        backgroundColor: Colors.amber,
      ),

      body: FutureBuilder<Map>( // Carrega o dado no 'builder' somente quando a função getData() for executada
        future: getData(),
        builder: (context, snapshot) {
         switch(snapshot.connectionState){
           case ConnectionState.none:
           case ConnectionState.waiting:

             return Center(
               child: Text("Carregando Dados...",
                 style: TextStyle(
                  color: Colors.amber,
                  fontSize:25.0),
              textAlign: TextAlign.center)
             );

             default:
               if(snapshot.hasError){
                 return Center(
                     child: Text("Erro ao Carregar dados :(",
                         style: TextStyle(
                             color: Colors.amber,
                             fontSize:25.0),
                         textAlign: TextAlign.center)
                 );
               }
               else{
                 dolar = snapshot.data["results"]["currencies"]["USD"]["buy"];
                 jpy = snapshot.data["results"]["currencies"]["JPY"]["buy"];

                 return SingleChildScrollView(
                   padding: EdgeInsets.all(10.0),
                   child: Column(
                     crossAxisAlignment: CrossAxisAlignment.stretch,
                     children: [
                       Icon(Icons.monetization_on, size: 150.0, color: Colors.amber),

                       buildTextField("Reais", "R\$ ", realControler, _realChange),

                       buildTextField("Dólares", "US\$ ", dolarControler, _dolarChange),

                       buildTextField("Yen", "¥ ", jpyControler, _jpyChange),

                     ],
                   ),
                 );
               }
         }
        }),
    );
  }
}

Future<Map> getData() async {
  http.Response response = await http.get(request);
  return json.decode(response.body);
}


Widget buildTextField(String labelText, String prefixText, TextEditingController controller, Function function){
  return Padding(
      padding: EdgeInsets.fromLTRB(5.0, 20.0, 5.0, 10.0),
      child: TextField(
        decoration: InputDecoration(
            labelText: labelText,
            labelStyle: TextStyle(color: Colors.amber),
            border: OutlineInputBorder(),
            prefixText: prefixText
        ),
        keyboardType: TextInputType.number,
        controller: controller,
        onChanged: function,
        style: TextStyle(
            color: Colors.amber, fontSize: 25.0
        ),
      ) );
}
