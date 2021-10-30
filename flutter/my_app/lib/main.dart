import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget{
  @override
  State<StatefulWidget> createState(){
    return _MyApp();
  }
}

class _MyApp extends State<MyApp> {
  var switchValue = false;
  String test = 'hello';
  Color _color = Colors.amber;
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
            primarySwatch: Colors.blue,
            visualDensity: VisualDensity.adaptivePlatformDensity),
      darkTheme: ThemeData.light(),
      home: Scaffold(
        body: Center(
          child: ElevatedButton(
            child: Text('$test'),
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(_color)
            ),
            onPressed: () {
              if(test == 'hello'){
                setState(() {
                  test = 'flutter';
                  _color = Colors.blue;
                });
              }
              else{
                setState(() {
                  test = 'hello';
                  _color = Colors.amber;
                });
              }
            },
          ),
          // -----토글버튼
          // child: Switch(
          //   value: switchValue,
          //   onChanged: (value) {
          //     setState(() {
          //       switchValue = value;
          //     });
          //   },
          // )
        ),
      )
      );
  }
}
