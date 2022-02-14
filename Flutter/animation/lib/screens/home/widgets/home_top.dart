import 'package:animation/screens/home/widgets/category_view.dart';
import 'package:flutter/material.dart';


class HomeTop extends StatelessWidget {

  final Animation<double> containerGrowAnimated;

  const HomeTop({Key? key, required this.containerGrowAnimated}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    return Container(
      height: screenSize.height * 0.4,
      decoration: const BoxDecoration(
        image: DecorationImage(
          image: AssetImage("images/background.jpg"),
          fit: BoxFit.cover
        )
      ),
      child: SafeArea(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            const Text(
              "Bem Vindo, Lucas!!",
              style: TextStyle(fontSize: 30, fontWeight: FontWeight.w300, color: Colors.white),
            ),

            Container(
              alignment: Alignment.topRight,
              width: containerGrowAnimated.value * 120,
              height: containerGrowAnimated.value * 120,
              decoration: const BoxDecoration(
                shape: BoxShape.circle,
                image: DecorationImage(// ToDo Mudar a imagem depois
                  image: AssetImage("images/perfil.jpg"),
                  fit: BoxFit.cover
                )
              ),

              child: Container(
                width: containerGrowAnimated.value * 35,
                height: containerGrowAnimated.value * 35,
                margin: const EdgeInsets.only(left: 80),
                child: Center(
                  child: Text( "2",
                    style: TextStyle(
                        fontSize: containerGrowAnimated.value * 15,
                        fontWeight: FontWeight.w400,
                        color: Colors.white
                    )
                  ),
                ),
                decoration: const BoxDecoration(
                    shape: BoxShape.circle,
                    color: Color.fromRGBO(80, 210, 194, 1.0)
                ),
              ),
            ),

            CategoryView()

          ],
        ),
      ),
    );

  }
}
