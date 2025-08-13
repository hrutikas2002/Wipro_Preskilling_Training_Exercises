function getLength() {
    // Get the input value
    const text = document.getElementById('txt').value;
    // Calculate length
    const length = text.length;
    // Display the length
    document.getElementById('len').innerText = 'Length of text: ' + length;
}