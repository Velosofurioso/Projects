import 'package:animation/screens/login/widgets/input_field.dart';
import 'package:flutter/material.dart';

class FormContainer extends StatelessWidget {
  const FormContainer({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.symmetric(horizontal: 20),
      child: Form(
        child: Column(
          children: const [
            InputField(hint: "Username", icon: Icons.person_outline),
            InputField(hint: "Password", obscure: true , icon: Icons.lock_outline),
          ],
        ),
      ),
    );
  }
}
