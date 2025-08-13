const maxLength = 50;
const charCount = document.getElementById('count');
const input = document.getElementById('txt');

function increaseCount() {
        const remainingChar = maxLength - input.value.length;
        charCount.innerText = remainingChar+" characters are remaining";
}