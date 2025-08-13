function addTask() {
    const taskInput = document.getElementById("taskInput");
    const taskValue = taskInput.value.trim();

    if (taskValue === "") {
        alert("Please enter a task!");
        return;
    }

    const listItem = document.createElement("li");
    listItem.textContent = taskValue;

    const deleteBtn = document.createElement("button");
    deleteBtn.textContent = "Delete";
    deleteBtn.classList.add("delete-btn");
    deleteBtn.onclick = function () {
        listItem.remove();
    };

    listItem.appendChild(deleteBtn);
    document.getElementById("taskList").appendChild(listItem);

    taskInput.value = "";
}
