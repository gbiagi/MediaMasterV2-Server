package sdev.mediamasterserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/mmserver")
public class ApiController {
    @Value("${tmdb_key}")
    private String tmdbApiKey;
    @Value("${rawg_key}")
    private String rawgApiKey;

    @Autowired
    private RestClient restClient;


    // tmbd img url https://image.tmdb.org/t/p/w500 + poster_path
    // open library img https://covers.openlibrary.org/b/id/{}.jpg add cover id


    // ****************************** MOVIE AND TV METHODS ******************************

    // Search methods
    @GetMapping("/searchmovie/{query}")
    public ResponseEntity<String> searchMovie(@PathVariable String query) {
        // Call the tmdb api to get search results
        String url = UriComponentsBuilder
                .fromUri(URI.create("https://api.themoviedb.org/3/search/movie"))
                .queryParam("query", query)
                .build()
                .toUriString();

        String response = restClient.get()
                .uri(url)
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + tmdbApiKey)
                .retrieve()
                .body(String.class);

        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(response);
    }

    @GetMapping("/searchtv/{query}")
    public ResponseEntity<String> searchTv(@PathVariable String query) {
        // Call the tmdb api to get search results
        String url = UriComponentsBuilder
                .fromUri(URI.create("https://api.themoviedb.org/3/search/tv"))
                .queryParam("query", query)
                .build()
                .toUriString();
        String response = restClient.get()
                .uri(url)
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + tmdbApiKey)
                .retrieve()
                .body(String.class);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(response);
    }

    // Get methods
    @GetMapping("/movie/{id}")
    public ResponseEntity<String> getMovie(@PathVariable String id) {
        String url = UriComponentsBuilder
                .fromUri(URI.create("https://api.themoviedb.org/3/movie/"))
                .queryParam("", id)
                .build()
                .toUriString();

        String response = restClient.get()
                .uri(url)
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + tmdbApiKey)
                .retrieve()
                .body(String.class);

        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(response);
    }
    @GetMapping("/tv/{id}")
    public ResponseEntity<String> getTV(@PathVariable String id) {
        String url = UriComponentsBuilder
                .fromUri(URI.create("https://api.themoviedb.org/3/tv/" + id))
                .build()
                .toUriString();

        String response = restClient.get()
                .uri(url)
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + tmdbApiKey)
                .retrieve()
                .body(String.class);

        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(response);
    }




    // TODO: Get book

    // TODO: Get game

    // TODO: Get media list?


    // Post methods

    // TODO: Create list

    // TODO: Modify list


    // Delete methods

    // TODO: Delete list

    //TODO: Delete media from list

}
