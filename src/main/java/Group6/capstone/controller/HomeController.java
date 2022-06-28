package Group6.capstone.controller;

import Group6.capstone.domain.Point;
import Group6.capstone.service.PointService;
import Group6.capstone.service.TempService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PointService pointService;
    private final TempService tempService;

    @ModelAttribute("pointList")
    public List<Point> pointList() {
        return pointService.findAll();
    }

    // Map service (Home)
    @RequestMapping("/")
    public String home(Model model) {
        List<Point> pointList = pointService.findAll(); // find all Point
        Map<Long, Integer> pointLiveCount = new HashMap<>();
        for (Point point : pointList) { // each point
            pointLiveCount.put(point.getId(), tempService.getLiveCountHome(point.getId())); // get counted number on live
        }
        model.addAttribute("allCounted", pointLiveCount);
        return "home";
    }

    // statics service (by point.id), default statics service -> ("세종대 정문")
    @GetMapping(path = {"/statics/{id}", "/static"})
    public String statics(@PathVariable(value = "id", required = false) Long id, Model model) {
        Point point = pointService.findByName("세종대 정문"); // find one Point (if data has value)
        if (id != null) {
            point = pointService.findOne(id); // find one Point (if data doesn't have value)
        }
        List<Integer> staticsData = pointService.getStaticsData(point.getPlace()); // get data for one week
        int counted = tempService.getLiveCount(id); // get focused Point's counted number on live
        model.addAttribute("point", point);
        model.addAttribute("counted", counted);
        model.addAttribute("staticsData", staticsData);

        return "statics";
    }


}
