// form 요소 가져오기
const form = document.getElementById('myForm');

// form 제출 이벤트 리스너 등록
form.addEventListener('submit', function(event) {
    // 기본 동작(페이지 새로고침) 방지
    event.preventDefault();

    // 입력된 이름 가져오기
    const name = document.getElementById('nameInput').value;

    // 콘솔에 출력
    console.log('입력된 이름:', name);
});