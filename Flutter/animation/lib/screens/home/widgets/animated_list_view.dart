import 'package:animation/screens/home/widgets/list_data.dart';
import 'package:flutter/material.dart';

class AnimatedListView extends StatelessWidget {

  final Animation<EdgeInsets> listSlidePosition;

  const AnimatedListView({Key? key, required this.listSlidePosition}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Stack(
      alignment: Alignment.bottomCenter,
      children: [

        ListData(
          title: "Estudar Flutter",
          subtitle: "Com o curso na Udemy",
          imageProvider: AssetImage("images/perfil.jpg"),
          margin: listSlidePosition.value * 3,
        ),

        ListData(
          title: "Estudar Flutter",
          subtitle: "Com o curso na Udemy",
          imageProvider: AssetImage("images/perfil.jpg"),
          margin: listSlidePosition.value * 2,
        ),

        ListData(
          title: "Estudar Flutter 2",
          subtitle: "Com o curso na Udemy 2",
          imageProvider: AssetImage("images/perfil.jpg"),
          margin: listSlidePosition.value * 1,
        ),

        ListData(
          title: "Estudar Flutter",
          subtitle: "Com o curso na Udemy",
          imageProvider: AssetImage("images/perfil.jpg"),
          margin: listSlidePosition.value * 0,
        )

      ],
    );
  }
}
