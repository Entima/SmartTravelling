package pl.matt.smartTravelling.Trip;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripsController {

    private final TripService tripService;

    public TripsController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Trip> trips = tripService.getTrips();
        model.addAttribute("trips", trips);
        return "trips/all";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "trips/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveTrip(@Valid Trip trip, BindingResult result) {
        if (result.hasErrors()) {
            return "trips/add";
        }
        tripService.add(trip);
        return "redirect:/trip/all";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("trip", tripService.get(id));
        return "trips/edit";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editTrip(@Valid Trip trip, BindingResult result) {
        if (result.hasErrors()) {
            return "trips/edit";
        }
        tripService.add(trip);
        return "redirect:/trip/all";
    }
    @GetMapping("/delete/{id}")
    public String deleteTrip(@PathVariable long id) {
        tripService.delete(id);
        return "redirect:/trip/all";
    }
    @GetMapping("/show/{id}")
    public String showTrip(Model model, @PathVariable long id) {
        model.addAttribute("trip", tripService.get(id).orElseThrow(EntityNotFoundException::new));
        return "trips/show";
    }
}

