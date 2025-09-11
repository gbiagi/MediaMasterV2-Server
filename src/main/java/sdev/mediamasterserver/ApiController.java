package sdev.mediamasterserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mmserver")
public class ApiController {
    // tmbd img url https://image.tmdb.org/t/p/w500 + poster_path
    // open library img https://covers.openlibrary.org/b/id/{}.jpg add cover id


    // Get methods
    // TODO: Get movie
    @GetMapping("/getmovie/{id}")
    public String getMovie(@PathVariable String id) {
        return String.format("Movie with id: %s", id);
    }

    // TODO: Get tv

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
