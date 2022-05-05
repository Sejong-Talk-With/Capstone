
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
center: new kakao.maps.LatLng(37.549926, 127.074799), //지도의 중심좌표.
level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

var content = '<div id ="label1"><span class="left"></span><span class="center">혼잡</span><span class="right"></span></div>';
var content1 = '<div class ="label2"><span class="left"></span><span class="center">원활</span><span class="right"></span></div>';

// 커스텀 오버레이가 표시될 위치입니다 
var position = new kakao.maps.LatLng(37.549926, 127.074799);  
var position1 = new kakao.maps.LatLng(37.551558, 127.074256);  

// 커스텀 오버레이를 생성합니다
var customOverlay1 = new kakao.maps.CustomOverlay({
    position: position,
    content: content,
});

var customOverlay2 = new kakao.maps.CustomOverlay({
    position: position1,
    content: content1
});




