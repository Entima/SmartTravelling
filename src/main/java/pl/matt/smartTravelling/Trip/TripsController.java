package pl.matt.smartTravelling.Trip;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.matt.smartTravelling.Home.UnauthorizedException;
import pl.matt.smartTravelling.Home.User;
import pl.matt.smartTravelling.Home.UserService;
import pl.matt.smartTravelling.Place.PlaceService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripsController {
    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

    private final TripService tripService;
    private final PlaceService placeService;
    private final UserService userService;

    public TripsController(TripService tripService, PlaceService placeService, UserService userService) {
        this.tripService = tripService;
        this.placeService = placeService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String showPosts(Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "") String password, @CookieValue(name = "userId", defaultValue = "0" ) Long userId) {
        checkLogin(login, password);
        List<TripEntity> tripEntities = tripService.getTripsByUserId(userId);
        model.addAttribute("trips", tripEntities);
        model.addAttribute("login", login);
        return "/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("trip", new TripEntity());
        return "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveTrip(@Valid TripEntity tripEntity, BindingResult result, @CookieValue(name = "userId", defaultValue = "0" ) Long userId) {
        if (result.hasErrors()) {
            return "/add";
        }
        tripEntity.setUserId(userId);
        tripService.add(tripEntity);
        return "redirect:/trips/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("trip", tripService.get(id));
        return "/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editTrip(@Valid TripEntity tripEntity, BindingResult result, @CookieValue(name = "userId", defaultValue = "0" ) Long userId) {
        if (result.hasErrors()) {
            return "/edit";
        }
        tripEntity.setUserId(userId);
        tripService.add(tripEntity);
        return "redirect:/trips/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrip(@PathVariable long id) {
        tripService.delete(id);
        return "redirect:/trips/all";
    }

    @GetMapping("/show/{id}")
    public String showTrip(Model model, @PathVariable long id) {
        model.addAttribute("trip", tripService.get(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("places", placeService.getTripPlaces(id));
        return "/show";
    }

    public void checkLogin(String login, String password) {
        List<User> users1 = userService.userGetByEmail(login, password);
        List<User> users = userService.userGetByLogin(login, password);
        if (users.size() == 0 && users1.size() == 0) {
            throw new UnauthorizedException();
        }
    }
}

