import 'dart:convert';
import 'dart:io';
import 'dart:async';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:path_provider/path_provider.dart';

void main() {
  runApp(MaterialApp(home: Home()));
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  final _taskController = TextEditingController();

  List _toDoList = [];
  Map<String, dynamic> _lastRemoved;
  int _lastRemovedPos;

  @override
  void initState() {
    super.initState();

    _readData().then((value) {
      setState(() {
        _toDoList = json.decode(value);
      });
      _refresh();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Lista de Tarefas"),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
      ),
      body: Column(
        children: [
          Container(
              padding: EdgeInsets.fromLTRB(17.0, 1.0, 7.0, 1.0),
              child: Row(children: [
                Expanded(
                  child: TextField(
                    decoration: InputDecoration(
                        labelText: "Nova Tarefa",
                        labelStyle: TextStyle(color: Colors.blueAccent)),
                    controller: _taskController,
                  ),
                ),

                RaisedButton(
                    onPressed: _addToDo,
                    color: Colors.blueAccent,
                    child: Text("ADD"),
                    textColor: Colors.white)
              ]),
          ),

          Expanded(child: RefreshIndicator(
            onRefresh: _refresh,
            child:  ListView.builder(
                padding: EdgeInsets.only(top: 10.0),
                itemCount: _toDoList.length,
                itemBuilder: buildItem
            ),
          ))
        ],
      ),
    );
  }

  Widget buildItem(context, index) {
      return Dismissible(
        key: Key(DateTime.now().microsecondsSinceEpoch.toString()),
        direction: DismissDirection.startToEnd,
        onDismissed:(direction) {
          setState(() {
            _lastRemoved = Map.from(_toDoList[index]);
            _lastRemovedPos = index;
            _toDoList.removeAt(index);

            _saveData();

            final snack = SnackBar(
              content: Text("Tarefa ${_lastRemoved["title"]} removida"),
              action: SnackBarAction(label: "Desfazer",
              onPressed: () {
                setState(() {
                  _toDoList.insert(_lastRemovedPos, _lastRemoved);
                  _saveData();
                });
              }),
              duration: Duration(seconds: 2),
            );

            Scaffold.of(context).removeCurrentSnackBar();
            Scaffold.of(context).showSnackBar(snack);

          });
        },

        background: Container(
          color: Colors.red,
          child: Align(
            alignment: Alignment(-0.9, 0.0),
            child: Icon(Icons.delete, color: Colors.white),
          ),
        ),

        child: CheckboxListTile(
          title: Text(_toDoList[index]["title"]),
          value: _toDoList[index]["ok"],
          secondary: CircleAvatar( // Add icone lateral esquerdo
              child: Icon(
                  _toDoList[index]["ok"] ? Icons.check : Icons.error
              )),
          onChanged: (checked) {
            setState(() {
              _toDoList[index]["ok"] = checked;
              _saveData();
            });
            _refresh();
          },
        ),
      );
    }

  Future<File> _getFile() async {
    final directory =
        await getApplicationDocumentsDirectory(); // retorna o caminho onde o app salva os dados
    return File("${directory.path}/data.json");
  }

  Future<File> _saveData() async {
    String data = json.encode(_toDoList); // parse JSON

    final file = await _getFile();
    return file.writeAsString(data);
  }

  Future<String> _readData() async {
    try {
      final file = await _getFile();
      return file.readAsString();
    } catch (e) {
      return null;
    }
  }

  void _addToDo() {
    Map<String, dynamic> newToDo = Map();
    newToDo["title"] = _taskController.text;
    _taskController.text = "";

    newToDo["ok"] = false;
    setState(() {
      _toDoList.add(newToDo);
      _saveData();
    });
  }

  Future<Null> _refresh() async {
    await Future.delayed(Duration(seconds: 1));

    setState(() {
      _toDoList.sort((a, b){
        if(a["ok"] && !b["ok"])
          return 1;
        else if(!a["ok"] && b["ok"])
          return -1;
        else
          return 0;
      });
    });

      _saveData();
      return null;
    }
  }

