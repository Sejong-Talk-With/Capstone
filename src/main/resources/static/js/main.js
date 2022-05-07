
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.549926, 127.074799), //지도의 중심좌표.
    level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

var content1 = '<button class =\"btn btn-danger big-circle\" type=\"button\"onclick=\"toggleMenu(\'ex\')\";><span class="text1">350%</span></button>';
var content2 = '<button class ="btn btn-danger big-circle"><span class="text1">210%</span></button>';
var content3 = '<button class ="btn btn-danger big-circle"><span class="text1">270%</span></button>';

var content4 = '<button class ="btn btn-warning mid-circle"><span class="text1">150%</span></button>';
var content5 = '<button class ="btn btn-warning mid-circle"><span class="text1">130%</span></button>';
var content6 = '<button class ="btn btn-warning mid-circle"><span class="text1">140%</span></button>';

var content7 = '<button class ="btn btn-success small-circle"><span class="text1">10%</span></button>';
var content8 = '<button class ="btn btn-success small-circle"><span class="text1">23%</span></button>';
var content9 = '<button class ="btn btn-success small-circle"><span class="text1">77%</span></button>';
var content10 = '<button class ="btn btn-success small-circle"><span class="text1">50%</span></button>';

// 커스텀 오버레이가 표시될 위치입니다
var position1 = new kakao.maps.LatLng(37.549409, 127.075770);
var position2 = new kakao.maps.LatLng(37.547775, 127.073700);
var position3 = new kakao.maps.LatLng(37.552667, 127.073059);

var position4 = new kakao.maps.LatLng(37.552101, 127.073609);
var position5 = new kakao.maps.LatLng(37.551001, 127.074609);
var position6 = new kakao.maps.LatLng(37.548805, 127.074895);

var position7 = new kakao.maps.LatLng(37.550257, 127.075006);
var position8 = new kakao.maps.LatLng(37.550255, 127.073560);
var position9 = new kakao.maps.LatLng(37.549761, 127.074258);
var position10 = new kakao.maps.LatLng(37.548780, 127.074064);

// 커스텀 오버레이를 생성합니다
var customOverlay1 = new kakao.maps.CustomOverlay({
    position: position1,
    content: content1,
});

var customOverlay2 = new kakao.maps.CustomOverlay({
    position: position2,
    content: content2,
});

var customOverlay3 = new kakao.maps.CustomOverlay({
    position: position3,
    content: content3,
});

var customOverlay4 = new kakao.maps.CustomOverlay({
    position: position4,
    content: content4,
});

var customOverlay5 = new kakao.maps.CustomOverlay({
    position: position5,
    content: content5,
});

var customOverlay6 = new kakao.maps.CustomOverlay({
    position: position6,
    content: content6,
});

var customOverlay7 = new kakao.maps.CustomOverlay({
    position: position7,
    content: content7,
});

var customOverlay8 = new kakao.maps.CustomOverlay({
    position: position8,
    content: content8,
});

var customOverlay9 = new kakao.maps.CustomOverlay({
    position: position9,
    content: content9,
});

var customOverlay10 = new kakao.maps.CustomOverlay({
    position: position10,
    content: content10,
});



