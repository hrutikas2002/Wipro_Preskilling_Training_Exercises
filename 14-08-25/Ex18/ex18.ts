// Define an enum for HTTP Status Codes
enum HttpStatusCode {
    OK = 200,
    NOTFOUND = 404,
    ACCESSDENIED = 403,
    INTERNALERROR = 500
}

// Example usage
console.log("Status-OK:", HttpStatusCode.OK);
console.log("Status-NOTFOUND:", HttpStatusCode.NOTFOUND);
console.log("Status-ACCESSDENIED:", HttpStatusCode.ACCESSDENIED);
console.log("Status-INTERNALERROR:", HttpStatusCode.INTERNALERROR);
