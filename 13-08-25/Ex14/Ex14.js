let cities = ["Pune", "Mumbai", "Delhi", "Bangalore", "Chennai", "Nashik"];

function loadCities() {
    // Sort cities alphabetically
    let sortedCities = cities.slice().sort();

    // Get dropdown element
    let dropdown = document.getElementById("cityDropdown");

    // Clear existing options (except first placeholder)
    dropdown.innerHTML = '<option value="">-- Select a City --</option>';

    // Add sorted cities to dropdown
    sortedCities.forEach(city => {
        let option = document.createElement("option");
        option.value = city;
        option.textContent = city;
        dropdown.appendChild(option);
    });
}