package Group6.capstone.controller;

import Group6.capstone.domain.Info;
import Group6.capstone.domain.Point;
import Group6.capstone.repository.InfoRepository;
import Group6.capstone.service.InfoService;
import Group6.capstone.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PointService pointService;
    private final InfoRepository infoRepository;
    private final InfoService infoService;


    @RequestMapping("/")
    public String home(Model model) {
        List<Point> pointList = pointService.findAll();
        model.addAttribute("pointList", pointList);
        return "home";
    }

    @GetMapping("/statics")
    public String statics(Model model) {
        List<Point> pointList = pointService.findAll();
        Point point = pointService.findOne(372L);
        int counted = infoService.getLiveCount();
        model.addAttribute("pointList", pointList);
        model.addAttribute("point", point);
        model.addAttribute("counted",counted);

        return "statics";
    }

    @GetMapping("/statics/{id}")
    public String statics(@PathVariable("id") Long id, Model model) {
        List<Point> pointList = pointService.findAll();
        Point point = pointService.findOne(id);
        int counted = infoService.getLiveCount();
        model.addAttribute("pointList", pointList);
        model.addAttribute("point", point);
        model.addAttribute("counted",counted);
        return "statics";
    }

    @GetMapping("/statics/default")
    public String staticsDefault(Model model) {
        return "staticsDefault";
    }

    @GetMapping("/infos")
    @ResponseBody
    public List<Info> infos() {
        List<Info> infoList = infoRepository.selectAllSql();
        return infoList;
    }

    @GetMapping("/info-live/{id}")
    @ResponseBody
    public int infos(@PathVariable long id) {
         return infoService.getLiveCount();
    }
}
