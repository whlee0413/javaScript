function CheckWeight(name,height,weight) {
    this.myName = name;
    this.myHeight = height;
    this.myWeight = weight;
    this.minWeight;
    this.maxWeight;
    // this.getInfo = function(){
    //     var str = "";
    //     str += "이름은: " + this.myName + ", ";
    //     str += "키: " + this.myHeight + ", ";
    //     str += "몸무게: " + this.myWeight;
    //     return str;
    // }
    // this.getResult = function(){
    //     this.minWeight = (this.myHeight -100) * 0.9 - 5;
    //     this.maxWeight = (this.myHeight -100) * 0.9 + 5;
    //     if(this.myWeight < this.minWeight){
    //         return "체중미달";
    //     } else if(this.myWeight > this.maxWeight){
    //         return "체중과다";
    //     } else {
    //         return "정상범위";
    //     }
    // }
}
CheckWeight.prototype.getInfo = function(){
    var str = "";
    str += "이름은: " + this.myName + ", ";
    str += "키: " + this.myHeight + ", ";
    str += "몸무게: " + this.myWeight;
    return str;
}

CheckWeight.prototype.getResult = function(){
    this.minWeight = (this.myHeight -100) * 0.9 - 5;
    this.maxWeight = (this.myHeight -100) * 0.9 + 5;
    if(this.myWeight < this.minWeight){
        return "체중미달";
    } else if(this.myWeight > this.maxWeight){
        return "체중과다";
    } else {
        return "정상범위";
    }
}


var person = new CheckWeight("Lee", 181, 81);
console.log(person);
console.log(person.getInfo());
console.log(person.getResult());


