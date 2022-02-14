import 'package:bloc_pattern/bloc_pattern.dart';
import 'package:flutter/material.dart';
import 'package:fluttertube/blocs/favorite_bloc.dart';
import 'package:fluttertube/models/Video.dart';
import 'package:youtube_player_flutter/youtube_player_flutter.dart';

class Favorites extends StatelessWidget {
  const Favorites({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final _favBloc = BlocProvider.getBloc<FavoriteBloc>();

    return Scaffold(
      appBar: AppBar(
        title: const Text("Favoritos"),
        centerTitle: true,
        backgroundColor: Colors.black87,
      ),
      backgroundColor: Colors.black87,
      body: StreamBuilder<Map<String, Video>>(
        stream: _favBloc.outFav,
        initialData: const {},
        builder: (context, snapshot) {
          return ListView(
            children: snapshot.data!.values.map((v) {
              return InkWell(
                onTap: () {
                  YoutubePlayer(
                    controller: YoutubePlayerController(
                      initialVideoId: 'zn2GwbPG-tc', //Add videoID.
                      flags: const YoutubePlayerFlags(
                        hideControls: false,
                        controlsVisibleAtStart: true,
                        autoPlay: false,
                        mute: false,
                      ),
                    ),
                    showVideoProgressIndicator: true,
                    progressIndicatorColor: Colors.white70,
                  );

                },
                onLongPress: () {
                  _favBloc.toggleFavorite(v);
                },
                child: Row(
                  children: [
                    SizedBox(
                      height: 50,
                      width: 100,
                      child: Image.network(v.thumb),
                    ),
                    
                    Expanded(
                        child: Text(v.title, style: const TextStyle(color: Colors.white70), maxLines: 2)
                    )
                  ],
                ),
              );
            }).toList(),
          );
        },
      ),
    );
  }
}
