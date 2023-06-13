package com.example.exercicio8;

import java.util.ArrayList;
import java.util.List;

public class Times {
    public String name;
    public int img;

    public int titulos;

    public Times(String name, int titulos, int img) {
        this.name = name;
        this.img = img;
        this.titulos = titulos;
    }

    public static List<Times> getTimes() {
        List<Times> times = new ArrayList<>();

        times.add(new Times("Boston Celtics", 17, R.drawable.boston_celtics));
        times.add(new Times("Los Angeles Lakers", 17, R.drawable.la_lakers));
        times.add(new Times("Golden State Warriors", 7, R.drawable.golden_state_warriors));
        times.add(new Times("Chicago Bulls", 6, R.drawable.chicago_bulls));
        times.add(new Times("San Antonio Spurs", 5, R.drawable.sa_spurs));
        times.add(new Times("Detroit Pistons", 3, R.drawable.detroit_pistons));
        times.add(new Times("Philadelphia 76ers", 3, R.drawable.philadelphia_76ers));
        times.add(new Times("Miami Heat", 3, R.drawable.miami_heat));
        times.add(new Times("Milwaukee Bucks", 2, R.drawable.milwaukee_bucks));
        times.add(new Times("New York Knicks", 2, R.drawable.new_york_knicks));
        times.add(new Times("Houston Rockets", 2, R.drawable.houston_rockets));
        times.add(new Times("Cleveland Cavaliers", 1, R.drawable.cleveland_cavaliers));
        times.add(new Times("Dallas Mavericks", 1, R.drawable.dallas_mavericks));
        times.add(new Times("Seattle Supersonics", 1, R.drawable.seattle_supersonics));
        times.add(new Times("Washington Wizards", 1, R.drawable.washington_wizards));
        times.add(new Times("Portland Trail Blazers", 1, R.drawable.portland_trail_blazers));
        times.add(new Times("Atlanta Hawks", 1, R.drawable.atlanta_hawks));
        times.add(new Times("Sacramento Kings", 1, R.drawable.sacramento_kings));
        times.add(new Times("Baltimore Bullets", 1, R.drawable.baltimore_bullets));
        times.add(new Times("Toronto Raptors", 1, R.drawable.toronto_raptors));

        return times;
    }
}
