// Define an enum for HTTP Status Codes
var HttpStatusCode;
(function (HttpStatusCode) {
    HttpStatusCode[HttpStatusCode["OK"] = 200] = "OK";
    HttpStatusCode[HttpStatusCode["NOTFOUND"] = 404] = "NOTFOUND";
    HttpStatusCode[HttpStatusCode["ACCESSDENIED"] = 403] = "ACCESSDENIED";
    HttpStatusCode[HttpStatusCode["INTERNALERROR"] = 500] = "INTERNALERROR";
})(HttpStatusCode || (HttpStatusCode = {}));
// Example usage
console.log("Status-OK:", HttpStatusCode.OK);
console.log("Status-NOTFOUND:", HttpStatusCode.NOTFOUND);
console.log("Status-ACCESSDENIED:", HttpStatusCode.ACCESSDENIED);
console.log("Status-INTERNALERROR:", HttpStatusCode.INTERNALERROR);
