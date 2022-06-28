package Group6.capstone.Interceptor;

import Group6.capstone.domain.Point;
import Group6.capstone.service.InfoService;
import Group6.capstone.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

// point의 최근 info update 시간 이후에 들어온 temp에 대해서 새로운 info를 point와 연관관계를 맺어 생성하기 위한 Interceptor
@RequiredArgsConstructor
public class UpdateInterceptor implements HandlerInterceptor {

    private final InfoService infoService;
    private final PointService pointService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Point> pointList = pointService.findAll(); // find all Point
        for (Point point : pointList) { // each point
            infoService.createInfo(point); // make 연관관계 with Point (새로 생성된 Temp들에 대해서 새로운 Info 생성)
            pointService.updatePoint(point); // point의 lastCommittedTime update (최근 Info update 시간 update)
        }
        return true;
    }
}
