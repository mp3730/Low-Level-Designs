package BookMyShow;

import BookMyShow.Model.Enums.City;
import BookMyShow.Model.Movie;
import BookMyShow.Model.ShowDetails;
import BookMyShow.Model.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityAndTheatres = new HashMap<>();
    List<Theatre> allTheatreList = new ArrayList<>();

    public void addTheatre(City city, Theatre theatre){
        allTheatreList.add(theatre);

        List<Theatre> theatreList = cityAndTheatres.getOrDefault(city, new ArrayList<>());
        theatreList.add(theatre);
        cityAndTheatres.put(city, theatreList);
    }

    public Map<Theatre, List<ShowDetails>>getAllShowsInTheatres(Movie movie, City city){

        Map<Theatre, List<ShowDetails>> finalMapping = new HashMap<>();
        //get the theatres for city
        List<Theatre> theatreList = cityAndTheatres.get(city);

        //for each theatre get the Show details
        for(Theatre theatre : theatreList){
            List<ShowDetails> theatreShows = theatre.getShowDetails();
            List<ShowDetails> movieShows = new ArrayList<>();

            //we need to find the shows for particular movie
            for(ShowDetails show : theatreShows){
                if(show.getMovieName().getName() == (movie.getName())){
                    movieShows.add(show);
                }
            }

            if(!movieShows.isEmpty()){
                finalMapping.put(theatre, movieShows);
            }
        }

        return finalMapping;
    }
}
