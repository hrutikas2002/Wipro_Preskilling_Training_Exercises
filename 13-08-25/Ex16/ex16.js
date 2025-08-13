let images = [
    "image1.png",
    "image2.png",
    "image3.png",
    "image4.png"
];

let index = 0; // Track current image index

// Function to update the displayed image
function showImage() {
    document.getElementById("galleryImage").src = images[index];
}

function nextImage() {
    index++; 
    if (index >= images.length) { 
        index = 0; 
    }
    showImage();
}

function prevImage() {
    index--;
    if (index < 0) {
        index = images.length - 1;
    }
    showImage();
}

// Show the first image on page load
showImage();