package Group6.capstone.controller;

import Group6.capstone.domain.Info;
import Group6.capstone.domain.Point;
import Group6.capstone.repository.InfoRepository;
import Group6.capstone.service.InfoService;
import Group6.capstone.service.PointService;
import lombok.AllArgsConstructor;
import lombok.Data;
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
        for (Point point : pointList) {
            infoService.getLiveCountHome(point.getId());
        }
        model.addAttribute("pointList", pointList);
        return "home";
    }

    @GetMapping("/statics")
    public String statics(Model model) {
        List<Point> pointList = pointService.findAll();
        Point point = pointService.findByName("세종대 정문");
        List<Integer> staticsData = pointService.getStaticsData("세종대 정문");
        int counted = infoService.getLiveCount(point.getId());
        model.addAttribute("pointList", pointList);
        model.addAttribute("point", point);
        model.addAttribute("counted",counted);
        model.addAttribute("staticsData", staticsData);

        return "statics";
    }

    @GetMapping("/statics/{id}")
    public String statics(@PathVariable("id") Long id, Model model) {
        List<Point> pointList = pointService.findAll();
        Point point = pointService.findOne(id);
        List<Integer> staticsData = pointService.getStaticsData(point.getPlace());
        int counted = infoService.getLiveCount(id);
        model.addAttribute("pointList", pointList);
        model.addAttribute("point", point);
        model.addAttribute("counted",counted);
        model.addAttribute("staticsData", staticsData);

        return "statics";
    }

    @GetMapping("/statics/default")
    public String staticsDefault(Model model) {
        return "staticsDefault";
    }

    @GetMapping("/infos")
    @ResponseBody
    public Result<List<Info>> infos() {
        List<Info> infoList = infoService.getLiveCountAll();
        Result<List<Info>> result = new Result<>(infoList.size(), infoList);
        return result;
    }

    @GetMapping("/info-live/{id}")
    @ResponseBody
    public int infos(@PathVariable long id) {
         return infoService.getLiveCount(id);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{ // 한번 감싸주기 위함. 그냥 List를 반환하면 JSON으로 list만 반환 되므로 유연성이 떨어짐. 추후에 count등 추가하기 위해선 감싸줘야함
        private int count;
        private T data;
    }
}
