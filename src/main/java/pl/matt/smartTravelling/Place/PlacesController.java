package pl.matt.smartTravelling.Place;

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
@RequestMapping("/places")
public class PlacesController {

    private final PlaceService placeService;

    public PlacesController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Place> places = placeService.getPlaces();
        model.addAttribute("places", places);
        return "places/all";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("place", new Place());
        return "places/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String savePlace(@Valid Place place, BindingResult result) {
        if (result.hasErrors()) {
            return "places/add";
        }
        placeService.add(place);
        return "redirect:/place/all";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("place", placeService.get(id));
        return "places/edit";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPlace(@Valid Place place, BindingResult result) {
        if (result.hasErrors()) {
            return "places/edit";
        }
        placeService.add(place);
        return "redirect:/place/all";
    }
    @GetMapping("/delete/{id}")
    public String deletePlace(@PathVariable long id) {
        placeService.delete(id);
        return "redirect:/place/all";
    }
    @GetMapping("/show/{id}")
    public String showPlace(Model model, @PathVariable long id) {
        model.addAttribute("place", placeService.get(id).orElseThrow(EntityNotFoundException::new));
        return "places/show";
    }
}