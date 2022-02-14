import 'package:flutter/material.dart';

class InputField extends StatelessWidget {

  final String hint;
  final bool obscure;
  final IconData icon;

  const InputField({Key? key, required this.hint, this.obscure = false, required this.icon}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: const BoxDecoration(
        border: Border(
          bottom: BorderSide(
            color: Colors.white24,
            width: 0.5
          ),
        ),
      ),
      child: TextFormField(
        obscureText: obscure,

        style: const TextStyle(
          color: Colors.white
        ),

        decoration: InputDecoration(
          icon: Icon(
            icon,
            color: Colors.white,
          ),
          border: InputBorder.none,
          hintText: hint,
          hintStyle: const TextStyle(
              color: Colors.white,
              fontSize: 15
          ),

          contentPadding: const EdgeInsets.only(
            top: 30,
            right: 30,
            bottom: 30,
            left: 5,
          )
        ),

      ),
    );
  }
}
