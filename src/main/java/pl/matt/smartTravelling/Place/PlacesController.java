package pl.matt.smartTravelling.Place;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/places")
public class PlacesController {

    private final PlaceService placeService;

    public PlacesController(PlaceService placeService) {
        this.placeService = placeService;
    }


    @RequestMapping(value = "/addPlaces/{tripId}", method = RequestMethod.GET)
    public String showAddForm(Model model, @PathVariable Long tripId) {
        PlaceEntity p = new PlaceEntity();
        p.setTripId(tripId);
        model.addAttribute("place", p);
        return "/addPlaces";
    }

    @RequestMapping(value = "/addPlaces", method = RequestMethod.POST)
    public Object savePlace(@Valid PlaceEntity placeEntity, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView m = new ModelAndView("/addPlaces");
            m.addObject("place", placeEntity);
            return m;
        }
        placeService.add(placeEntity);
        return "redirect:/trips/show/" + placeEntity.getTripId();
    }

    @RequestMapping(value = "/editPlaces/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("place", placeService.get(id));
        return "/editPlaces";
    }

    @RequestMapping(value = "/editPlaces", method = RequestMethod.POST)
    public String editPlace(@Valid PlaceEntity placeEntity, BindingResult result) {
        if (result.hasErrors()) {
            return "/editPlaces";
        }
        placeService.add(placeEntity);
        return "redirect:/trips/show/" + placeEntity.getTripId();
    }

    @GetMapping("/deletePlaces/{tripId}/{id}")
    public String deletePlace(@PathVariable long id, @PathVariable Long tripId) {
        placeService.delete(id);
        return "redirect:/trips/show/" + tripId;
    }

    @GetMapping("/showPlaces/{id}")
    public String showPlace(Model model, @PathVariable long id) {
        model.addAttribute("place", placeService.get(id).orElseThrow(EntityNotFoundException::new));
        return "/showPlaces";
    }
}