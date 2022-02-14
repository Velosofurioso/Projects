

import 'dart:convert';

import 'package:fluttertube/models/Video.dart';
import 'package:http/http.dart' as http;

const API_KEY = "AIzaSyDZhn0rKyDAPEcpwgozbmfG5BpvuEHvNTE";

class Api {

  late String _search;
  late String _nextToken;

  Future<List<Video>> search(String search) async {
    _search = search;

    http.Response response = await http.get(
      Uri.parse("https://www.googleapis.com/youtube/v3/search?part=snippet&q=$search&type=video&key=$API_KEY&maxResults=10")
    );

    return decode(response);
  }

  Future<List<Video>> nextPage() async {
    http.Response response = await http.get(
        Uri.parse("https://www.googleapis.com/youtube/v3/search?part=snippet&q=$_search&type=video&key=$API_KEY&maxResults=10&pageToken=$_nextToken")
    );

    return decode(response);
  }

  decode(http.Response response) {
    if(response.statusCode == 200) {
      var decode = json.decode(response.body);

      _nextToken = decode["nextPageToken"];

      List<Video> videos = decode["items"].map<Video>(
          (item) {
            return Video.fromJson(item);
          }
      ).toList();
      return videos;
    }

    else {
      throw Exception("Failed to load Videos");
    }
  }
}