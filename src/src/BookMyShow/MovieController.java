package BookMyShow;

import BookMyShow.Model.Enums.City;
import BookMyShow.Model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityAndMovies = new HashMap<>();
    List<Movie> allMovies = new ArrayList<>();

    public void addMovies(Movie movie, City city){
        allMovies.add(movie);

        List<Movie> movieList = cityAndMovies.getOrDefault(city, new ArrayList<>());
        movieList.add(movie);
        cityAndMovies.put(city,movieList);
    }

    public Movie getMovieByName(String movie){
        for(Movie temp : allMovies){
            if(temp.getName().equals(movie)){
                return temp;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city){
        return cityAndMovies.get(city);
    }
}
