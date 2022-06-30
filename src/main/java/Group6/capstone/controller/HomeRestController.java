package Group6.capstone.controller;

import Group6.capstone.domain.Temp;
import Group6.capstone.service.TempService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// for REST API
@RestController
@RequiredArgsConstructor
public class HomeRestController {

    private final TempService tempService;

    @GetMapping("/info-live/{id}")
    public int infos(@PathVariable long id) {
        return tempService.getLiveCount(id); // get focused Point's counted number on live
    }

    @GetMapping("/infos")
    public Result<List<Temp>> temps() {
        List<Temp> tempList = tempService.getLiveData();
        return new Result<>(tempList.size(), tempList);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> { // 한번 감싸주기 위함. 그냥 List를 반환하면 JSON으로 list만 반환 되므로 유연성이 떨어짐. 추후에 count등 추가하기 위해선 감싸줘야함
        private int count;
        private T data;
    }
}
