const questions = [
    {
        question: "Which of the following is NOT a Java framework?",
        options: ["Spring", "Hibernate", "React", "Struts"],
        answer: "React"
    },
    {
        question: "In Spring Boot, which annotation is used to mark a class as a REST Controller?",
        options: ["@Controller", "@RestController", "@Service", "@Component"],
        answer: "@RestController"
    },
    {
        question: "Which HTTP method is used to update an existing resource in a REST API?",
        options: ["GET", "POST", "PUT", "DELETE"],
        answer: "PUT"
    },
    {
        question: "In Spring Data JPA, which method is used to retrieve all records from a table?",
        options: ["findById()", "findAll()", "getAll()", "retrieveAll()"],
        answer: "findAll()"
    },
    {
        question: "Which database query language is commonly used with MySQL in Java applications?",
        options: ["GraphQL", "SQL", "NoSQL", "XPath"],
        answer: "SQL"
    }
];

let currentQuestion = 0;
let score = 0;

function loadQuestion() {
    const q = questions[currentQuestion];
    document.getElementById("question").textContent = q.question;

    const optionsDiv = document.getElementById("options");
    optionsDiv.innerHTML = ""; // Clear previous options

    q.options.forEach(option => {
        const btn = document.createElement("button");
        btn.textContent = option;
        btn.classList.add("option");
        btn.onclick = () => checkAnswer(option);
        optionsDiv.appendChild(btn);
    });

    document.getElementById("feedback").textContent = "";
}

function checkAnswer(selected) {
    const correctAnswer = questions[currentQuestion].answer;
    if (selected === correctAnswer) {
        document.getElementById("feedback").textContent = "Correct!";
        score++;
    } else {
        document.getElementById("feedback").textContent = "Wrong! Correct answer:" +correctAnswer;
    }
    document.getElementById("score").textContent = "Score: "+score;
}

function nextQuestion() {
    currentQuestion++;
    if (currentQuestion < questions.length) {
        loadQuestion();
    } else {
        document.getElementById("question").textContent = "Quiz Completed!";
        document.getElementById("options").innerHTML = "";
        document.getElementById("feedback").textContent = "Correct Answers - "+score+" out of "+questions.length;
         document.getElementById("nextBtn").style.display = "none"; // Hide button
    }
}

// Load first question
loadQuestion();
