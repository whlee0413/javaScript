var score = 10;
function myFunc(){ // 함수 안에 선언 되어지는 변수 : 로컬변수
    var score = 20;
    // console.log("local " + score);
}
myFunc();
// console.log("global: " + score);

function newFunc(){
    console.log("global function");
}

function outerFunc(){
    function newFunc(){
    console.log("local function");
    }
    newFunc();
}
newFunc();
outerFunc();

//입력함수로 만들고 실행 구문에 넣어서 자체적 함수를 정의해서 호출하지 않고 실행가능.
(function(){
    console.log("return Func");
})();
