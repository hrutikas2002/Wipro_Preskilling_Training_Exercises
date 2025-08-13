function validateEmail() {
    let email = document.getElementById("email").value.trim();
    let emailError = document.getElementById("emailError");
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; 
    
    if (email === "") {
        emailError.textContent = "Email is required";
        return false;
    } else if (!emailPattern.test(email)) {
        emailError.textContent = "Enter a valid email address";
        return false;
    } else {
        emailError.textContent = "";
        return true;
    }
}

function validatePassword() {
    let password = document.getElementById("password").value.trim();
    let passwordError = document.getElementById("passwordError");

    if (password === "") {
        passwordError.textContent = "Password is required";
        return false;
    }
    passwordError.textContent = "";
    return true;
}

function validateForm() {
    let isEmailValid = validateEmail();
    let isPasswordValid = validatePassword();

    if (isEmailValid && isPasswordValid) {
        alert("Login successful!");
    }
}