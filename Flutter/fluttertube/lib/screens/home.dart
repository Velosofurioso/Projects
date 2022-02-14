import 'package:bloc_pattern/bloc_pattern.dart';
import 'package:flutter/material.dart';
import 'package:fluttertube/blocs/favorite_bloc.dart';
import 'package:fluttertube/blocs/video_bloc.dart';
import 'package:fluttertube/delegates/data_search.dart';
import 'package:fluttertube/models/Video.dart';
import 'package:fluttertube/screens/favorites.dart';
import 'package:fluttertube/widgets/videotile.dart';

class Home extends StatelessWidget {
  const Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {

    final _videoBloc = BlocProvider.getBloc<VideoBloc>();

    return Scaffold(
      appBar: AppBar(
        title: SizedBox(
          height: 25,
          child: Image.asset("images/youtube_logo_black.png"),
        ),
        elevation: 0,
        backgroundColor: Colors.black87,
        actions: [
          Align(
            alignment: Alignment.center,
            child: StreamBuilder<Map<String, Video>>(
              stream: BlocProvider.getBloc<FavoriteBloc>().outFav,
              builder: (context, AsyncSnapshot snapshot) {
                if(snapshot.hasData) {
                  return Text("${snapshot.data.length}");
                }
                else {
                  return Container();
                }
              },
            ),
          ),
          IconButton(icon: const Icon(Icons.star), onPressed: () {
            Navigator.of(context).push(
                MaterialPageRoute(builder: (context) => const  Favorites())
            );
          }),
          IconButton(icon: const Icon(Icons.search),
              onPressed: () async {
                String? result = await showSearch(context: context, delegate: DataSearch());
                if(result != null) {
                  _videoBloc.inSearch.add(result);
                }
              }
          )
        ],
      ),

      backgroundColor: Colors.black,
      body: StreamBuilder(
        stream: BlocProvider.getBloc<VideoBloc>().outVideos,
        initialData: const [],
        builder: (context, AsyncSnapshot snapshot) {
          if(snapshot.hasData) {
            return ListView.builder(
                itemBuilder: (context, index) {
                  if(index < snapshot.data.length) {
                    return VideoTile(video: snapshot.data[index]);
                  }
                  else if(index > 1) {
                    _videoBloc.inSearch.add(null);
                    return Container(
                      height: 40,
                      width: 40,
                      alignment: Alignment.center,
                      child: const CircularProgressIndicator(valueColor: AlwaysStoppedAnimation<Color>(Colors.red)),
                    );
                  }

                  else {
                    return Container();
                  }
                },
                itemCount: snapshot.data.length > 0 ? snapshot.data.length+ 1 : 0,
            );
          }
          else {
            return Container();
          }


        },
      ),
    );
  }
}
