
import 'dart:async';
import 'dart:ui';

import 'package:bloc_pattern/bloc_pattern.dart';
import 'package:fluttertube/api.dart';
import 'package:fluttertube/models/Video.dart';

class VideoBloc implements BlocBase {

  late Api api;

  late List<Video> videos;

  final _videosController = StreamController<List<Video>>();
  Stream get outVideos => _videosController.stream;

  final _searchController = StreamController<String>();
  Sink get inSearch => _searchController.sink;


  VideoBloc () {
    api = Api();

    _searchController.stream.listen(_search);
  }

  @override
  void addListener(VoidCallback listener) {
    // TODO: implement addListener
  }

  @override
  void dispose() {
    _videosController.close();
    _searchController.close();
  }

  @override
  // TODO: implement hasListeners
  bool get hasListeners => throw UnimplementedError();

  @override
  void notifyListeners() {
    // TODO: implement notifyListeners
  }

  @override
  void removeListener(VoidCallback listener) {
    // TODO: implement removeListener
  }

  void _search(String? search) async {
    if(search != null) {
      _videosController.sink.add([]);
      videos = await api.search(search);
    }
    else {
      videos += await api.nextPage();
    }

    _videosController.sink.add(videos);

  }


}