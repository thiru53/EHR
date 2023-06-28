function validateForm() {
    var email = document.getElementById("email").value;
    if (!validateEmail(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    var medicalHistory = document.getElementById("medicalHistory").value;
    if (!validateMedicalHistory(medicalHistory)) {
        alert("Please enter a valid medical history.");
        return false;
    }

    return true;
}

function validateEmail(email) {
    // Email validation logic
    var emailRegex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
    return emailRegex.test(email);
}

function validateMedicalHistory(medicalHistory) {
    // Medical history validation logic
    // Add your own validation rules based on your requirements
    return medicalHistory.length > 0;
}
