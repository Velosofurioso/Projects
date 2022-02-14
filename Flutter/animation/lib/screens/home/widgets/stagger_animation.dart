import 'package:animation/screens/home/widgets/animated_list_view.dart';
import 'package:animation/screens/home/widgets/fade_container.dart';
import 'package:animation/screens/home/widgets/home_top.dart';
import 'package:flutter/material.dart';

class StaggerAnimation extends StatelessWidget {

  final AnimationController controller;
  late final Animation<double> containerGrowAnimated;
  late final Animation<EdgeInsets> listSlidePosition;
  late final Animation<Color?> fadeAnimation;

  StaggerAnimation({Key? key, required this.controller}) : super(key: key) {
    containerGrowAnimated = CurvedAnimation(
        parent: controller,
        curve: Curves.ease
    );

    listSlidePosition = EdgeInsetsTween(
      begin: const EdgeInsets.only(bottom: 0),
      end: const EdgeInsets.only(bottom: 80),
    ).animate(
      CurvedAnimation(
          parent: controller,
          curve: const Interval(
            0.325,
            0.8,
            curve: Curves.ease
          )
      )
    );

    fadeAnimation = ColorTween(
      begin: Color.fromRGBO(247, 64, 106, 1.0),
      end: Color.fromRGBO(247, 64, 106, 0.0)
    ).animate(
      CurvedAnimation(
          parent: controller,
          curve: Curves.ease
      )
    );
  }

  Widget _buildAnimation(BuildContext context, Widget? child) {
    return Stack(
      children: [
        ListView (
          padding: EdgeInsets.zero,
          children: [

            HomeTop(
              containerGrowAnimated: containerGrowAnimated,
            ),

            AnimatedListView(listSlidePosition: listSlidePosition),

          ],
        ),

        IgnorePointer(
          child: FadeContainer(
            fadeAnimation: fadeAnimation,
          ),
        )
      ],
    );

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: AnimatedBuilder(
          animation: controller,
          builder: _buildAnimation,
        ),
      ),
    );
  }
}
