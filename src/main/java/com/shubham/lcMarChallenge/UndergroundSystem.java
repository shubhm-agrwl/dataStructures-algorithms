package com.shubham.lcMarChallenge;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

  public static void main(String[] args) {
    UndergroundSystem undergroundSystem = new UndergroundSystem();
    undergroundSystem.checkIn(45, "Leyton", 3);
    undergroundSystem.checkIn(32, "Paradise", 8);
    undergroundSystem.checkIn(27, "Leyton", 10);
    undergroundSystem.checkOut(45, "Waterloo", 15);
    undergroundSystem.checkOut(32, "Cambridge", 22);
    System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
  }

  class obj {

    int id;
    String station;
    int time;

    public obj(int id, String station, int time) {
      this.id = id;
      this.station = station;
      this.time = time;
    }

  }

  Map<Integer, obj> check;
  Map<String, Map<String, Integer>> res;
  Map<String, Map<String, Integer>> count;

  public UndergroundSystem() {
    this.count = new HashMap<>();
    this.res = new HashMap<>();
    this.check = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    obj o = new obj(id, stationName, t);
    check.put(id, o);
  }

  public void checkOut(int id, String stationName, int t) {
    obj checkout = check.get(id);
    if (check.containsKey(id)) {
      if (null != res.get(checkout.station)) {
        Map<String, Integer> totalTime = res.get(checkout.station);
        if (totalTime.containsKey(stationName)) {
          int c = count.get(checkout.station).get(stationName);
          count.get(checkout.station).put(stationName, c++);
          int time = res.get(checkout.station).get(stationName);
          res.get(checkout.station).put(stationName, time + t - checkout.time);
        } else {
          res.get(checkout.station).put(stationName, t - checkout.time);
          count.get(checkout.station).put(stationName, 1);
        }
      } else {
        Map<String, Integer> q = new HashMap<>();
        q.put(stationName, t - checkout.time);
        Map<String, Integer> w = new HashMap<>();
        w.put(stationName, 1);
        res.put(checkout.station, q);
        count.put(checkout.station, w);
      }
    }
  }

  public double getAverageTime(String startStation, String endStation) {
    int c = 0, time = 0;
    if (null != count.get(startStation)) {
      c = count.get(startStation).get(endStation);
    }
    if (null != res.get(startStation)) {
      time = res.get(startStation).get(endStation);
    }
    if (c != 0 && time != 0) {
      return time / c;
    }
    return 0;
  }

}
