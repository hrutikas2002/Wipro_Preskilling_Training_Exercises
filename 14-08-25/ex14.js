const userIdInput = document.getElementById("userId");
const passwordInput = document.getElementById("password");
const statusText = document.getElementById("status");

document.getElementById("loginBtn").addEventListener("click", () => {
    const userId = userIdInput.value;
    const password = passwordInput.value;

    if (userId && password) {
        localStorage.setItem("userId", userId);
        statusText.textContent = `Logged in as ${userId}`;
    } else {
        statusText.textContent = "Please enter both User ID and Password.";
    }
});

document.getElementById("logoutBtn").addEventListener("click", () => {
    localStorage.removeItem("userId");
    statusText.textContent = "Logged out.";
});

// Check if already logged in when page loads
window.addEventListener("load", () => {
    const savedUser = localStorage.getItem("userId");
    if (savedUser) {
        statusText.textContent = `Logged in as ${savedUser}`;
    }
});