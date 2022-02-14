import 'package:flutter/material.dart';

class CategoryView extends StatefulWidget {
  const CategoryView({Key? key}) : super(key: key);

  @override
  _CategoryViewState createState() => _CategoryViewState();
}

class _CategoryViewState extends State<CategoryView> {

  final List<String> categories = [
    "ESTUDOS",
    "COMPRAS",
    "VIAGENS"
  ];

  int categorySelected = 0;

  void previousCategory() {
    setState(() {
      categorySelected -= 1;
    });
  }

  void nextCategory() {
    setState(() {
      categorySelected += 1;
    });
  }


  @override
  Widget build(BuildContext context) {
    return Container(
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          IconButton(
              onPressed: categorySelected > 0 ? previousCategory : null,
              color: Colors.white,
              disabledColor: Colors.white30,
              icon: const Icon(Icons.arrow_back_ios_rounded, size: 20)
          ),

          Text(categories[categorySelected].toUpperCase(), style: const TextStyle(fontSize: 20, color: Colors.white, fontWeight: FontWeight.w300, letterSpacing: 1.2)),

          IconButton(
              onPressed: categorySelected < categories.length - 1 ? nextCategory : null,
              color: Colors.white,
              disabledColor: Colors.white30,
              icon: const Icon(Icons.arrow_forward_ios_rounded, size: 20)
          ),
        ],
      ),
    );
  }
}
