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

    var gender = document.getElementById("gender").value;
    if (!validateGender(gender)) {
        alert("Please enter a valid gender.");
        return false;
    }

    var dob = document.getElementById("dob").value;
    if (!validateDoB(dob)) {
        alert("Please enter a valid Date Of Birth.");
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
function validateGender(gender) {
    var genderRegex=/^(?:m|M|male|Male|f|F|female|Female|FEMALE|MALE|Not prefer to say)$/;
    return genderRegex.test(gender);
}

function validateDoB(dob) {
    var dobRegex = /^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;
    return dobRegex.test(dob);
}
