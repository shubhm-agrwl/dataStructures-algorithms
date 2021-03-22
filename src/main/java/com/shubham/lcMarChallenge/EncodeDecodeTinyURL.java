package com.shubham.lcMarChallenge;

import java.util.HashMap;
import java.util.UUID;

public class EncodeDecodeTinyURL {

  HashMap<String, String> tinyURLMap = new HashMap<>();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String uuid = UUID.randomUUID().toString().substring(0, 5);
    tinyURLMap.put(uuid, longUrl);
    return "http://tinyurl.com/" + uuid;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    String uuid = shortUrl.substring(shortUrl.indexOf(".com/") + 5, shortUrl.indexOf(".com/") + 10);
    return tinyURLMap.get(uuid);
  }

}
