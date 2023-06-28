function confirmRegistration() {
    var hasErrors = document.getElementsByClassName("errors").length > 0;
    if (hasErrors) {
        alert("There are errors in the form. Please correct them before submitting.");
        return false; // Prevent form submission
    }
    return true; // Allow form submission
}
