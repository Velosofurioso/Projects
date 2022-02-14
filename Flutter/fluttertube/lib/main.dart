import 'package:bloc_pattern/bloc_pattern.dart';
import 'package:flutter/material.dart';
import 'package:fluttertube/api.dart';
import 'package:fluttertube/blocs/favorite_bloc.dart';
import 'package:fluttertube/blocs/video_bloc.dart';
import 'package:fluttertube/screens/home.dart';

void main() {

  Api api = Api();
  api.search("Veloso");

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BlocProvider(
        child: const MaterialApp(
          title: 'FlutterTube',
          home: Home(),
          debugShowCheckedModeBanner: false,
        ),
        blocs: [
          Bloc((i) => VideoBloc()),
          Bloc((i) => FavoriteBloc()),
        ],
        dependencies: const []
    );
  }
}
