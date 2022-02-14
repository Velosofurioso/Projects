import 'package:flutter/material.dart';

class ListData extends StatelessWidget {

  final String title;
  final String subtitle;
  final ImageProvider imageProvider;
  final EdgeInsets margin;

  const ListData({Key? key, required this.title, required this.subtitle, required this.imageProvider, required this.margin}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: margin,
      decoration: BoxDecoration(
        color: Colors.white,
        border: Border(
          top: BorderSide(color: Colors.grey, width: 1.0),
          bottom: BorderSide(color: Colors.grey, width: 1.0)
        )
      ),

      child: Row(
        children: [
          Container(
            margin: EdgeInsets.only(top: 10, bottom: 10, left: 20, right: 20),
            width: 60,
            height: 60,
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              image: DecorationImage(image: imageProvider)
            ),
          ),

          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                title,
                style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.w400
                ),
              ),

              SizedBox(height: 5),

              Text(
                subtitle,
                style: TextStyle(
                    fontSize: 18,
                    color: Colors.grey,
                    fontWeight: FontWeight.w300
                ),
              )
            ],
          )
        ],
      ),
    );
  }
}
