package BookMyShow;

import BookMyShow.Model.*;
import BookMyShow.Model.Enums.City;
import BookMyShow.Model.Enums.SeatType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking {
    TheatreController theatreController;
    MovieController movieController;

    public Booking(){
        theatreController = new TheatreController();
        movieController = new MovieController();
        initialise();
    }

    public void initialise(){
        createMovies();
        createTheatres();
    }

    public void startBooking(City city, String movie){

        //Step1 : find the list of movies based on city
        List<Movie> movieList = movieController.getMoviesByCity(city);

        //Step2 : get the movie details for the user selected movie
        Movie selectedMovie = null;
        for(Movie m : movieList){
            if(m.getName().equals(movie)){
                selectedMovie = m;
            }
        }

        //Step3 : get the all the shows in every theatre for the selected movie and city
        Map<Theatre, List<ShowDetails>> allShows = theatreController.getAllShowsInTheatres(selectedMovie, city);

        //Step4 : select the show which user is interested in

    }

    public void createMovies(){
        Movie amaran = new Movie();
        amaran.setMovieId(1);
        amaran.setName("AMARAN");
        amaran.setDuration(150); //minutes

        Movie barfi = new Movie();
        barfi.setMovieId(2);
        barfi.setName("BARFI");
        barfi.setDuration(125); //mins

        movieController.addMovies(amaran, City.Chennai);
        movieController.addMovies(amaran, City.Bangalore);
        movieController.addMovies(barfi, City.Bangalore);
        movieController.addMovies(barfi, City.Gurgaon);
        movieController.addMovies(barfi, City.Chennai);
    }

    public void createTheatres(){

        Movie amaran = movieController.getMovieByName("AMARAN");
        Movie barfi = movieController.getMovieByName("BARFI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreens(createScreen());
        inoxTheatre.setCity(City.Chennai);
        List<ShowDetails> inoxShows = new ArrayList<>();
        ShowDetails inoxMorningShow = createShows(1, inoxTheatre.getScreens().get(0), amaran, 8);
        ShowDetails inoxEveningShow = createShows(2, inoxTheatre.getScreens().get(0), barfi, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShowDetails(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreens(createScreen());
        pvrTheatre.setCity(City.Bangalore);
        List<ShowDetails> pvrShows = new ArrayList<>();
        ShowDetails pvrMorningShow = createShows(3, pvrTheatre.getScreens().get(0), amaran, 13);
        ShowDetails pvrEveningShow = createShows(4, pvrTheatre.getScreens().get(0), barfi, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShowDetails(pvrShows);

        theatreController.addTheatre(City.Chennai, inoxTheatre);
        theatreController.addTheatre(City.Bangalore, pvrTheatre);
    }

    public List<Screen> createScreen(){
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenNumber(1);
        screen1.setSeatList(createSeats());
        screens.add(screen1);

        return screens;
    }

    private ShowDetails createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        ShowDetails show = new ShowDetails();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovieName(movie);
        show.setTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    public List<Seat> createSeats(){

        List<Seat> seatList = new ArrayList<>();

        //silver
        for(int i=0;i<20;i++){
            Seat temp = new Seat();
            temp.setSeatNumber(i);
            temp.setSeatType(SeatType.SILVER);
            seatList.add(temp);
        }

        //gold
        for(int i=20;i<50;i++){
            Seat temp = new Seat();
            temp.setSeatNumber(i);
            temp.setSeatType(SeatType.GOLD);
            seatList.add(temp);
        }

        //platinum
        for(int i=50;i<70;i++){
            Seat temp = new Seat();
            temp.setSeatNumber(i);
            temp.setSeatType(SeatType.PLATINUM);
            seatList.add(temp);
        }

        return seatList;
    }
}
