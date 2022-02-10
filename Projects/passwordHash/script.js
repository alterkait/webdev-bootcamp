console.clear();

const sliderProps = {
    fill: "#0B1EDF",
    background: "rgba(255,255,255, 0.2",
};

const slider = document.querySelector(".range_slider");
const sliderValue = document.querySelector("length_title");

slider.querySelector("input").addEventListener("input", event =>{
    sliderValue.setAttribute("data-length", event.target.value);
    applyFill(event.target);
});

applyFill(slider.querySelector("input"));

function applyFill(slider) {
	const percentage = (100 * (slider.value - slider.min)) / (slider.max - slider.min);
	const bg = `linear-gradient(90deg, ${sliderProps.fill} ${percentage}%, ${sliderProps.background} ${percentage +0.1}%)`;
	slider.style.background = bg;
	sliderValue.setAttribute("data-length", slider.value);
}

// ----------------------------- 

const randomFunc = {
    lower: getRandomLower, upper: getRandomUpper, number: getRandomNumber, symbol: getRandomSymbol,
};

//More secure Random Algorithm:

function secureMathRandom(){
    return window.crypto.getRandomValues(new Uint32Array(1))[0] / (Math.pow(2,32) - 1);
}

//Generate Randoms

function getRandomLower(){
    return String.fromCharCode(Math.floor(Math.random() * 26) + 97); 
}
function getRandomUpper(){
    return String.fromCharCode(Math.floor(Math.random() * 26) + 65);
}
function getRandomNumber(){
    return String.fromCharCode(Math.floor(secureMathRandom() * 10) + 48);
}
function getRandomSymbol(){
    const symbols = '~!@#$%^&*()_+{}":?><;.,';
    return symbols[Math.floor(Math.random() * symbols.length)];

}

// The Viewbox where the result will be shown
const resultEl = document.getElementById("result");
// The input slider, will use to change the length of the password
const lengthEl = document.getElementById("slider");

// Checkboxes representing the options that is responsible to create differnt type of password based on user
const uppercaseEl = document.getElementById("uppercase");
const lowercaseEl = document.getElementById("lowercase");
const numberEl = document.getElementById("number");
const symbolEl = document.getElementById("symbol");