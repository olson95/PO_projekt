document.getElementById('applyFilter').addEventListener('click', function() {
    // Tutaj dodaj kod obsługujący naciśnięcie przycisku "Ok"
    // Na razie zostawmy go pustym
    console.log('Przycisk "Ok" został naciśnięty');
});


function addToCart(){
    // let quantity = document.getElementById('prodQuantity');
    // if(quantity <= 0){
    //     alert("Ilość produktów musi być większa od 0!")
    // }
    // else {
        const modal = document.getElementById('myModal');
        modal.style.display = 'block';
    // }

}

function validateQuantity() {
    let quantityInput = document.getElementById('prodQuantity');
    if (quantityInput.value < 1) {
        quantityInput.value = 1;
    }
}

function contactChoice(){
    const modal = document.getElementById('contactModal');
    modal.style.display = 'block';
}


function sendMessage(){
    const modal = document.getElementById('sentInfo');
    modal.style.display = 'block';
}

function cancelContact() {
    let name = document.getElementById("guestName").value;
    let guestLastname = document.getElementById("guestLastname").value;
    let email = document.getElementById("guestEmail").value;
    let subject = document.getElementById("guestSubject").value;
    let message = document.getElementById("guestMessage").value;

    let text = "Czy na pewno chcesz anulować?\n";
    if (confirm(text) === true) {
        window.location.href ='/shop';
    } else {
        document.getElementById("guestName").value = name;
        document.getElementById("guestLastname").value = guestLastname;
        document.getElementById("guestEmail").value = email;
        document.getElementById("guestSubject").value = subject;
        document.getElementById("guestMessage").value = message;
    }
}

function validateForm() {
    const nameInput = document.getElementById('guestName');
    const lastnameInput = document.getElementById('guestLastname');
    const emailInput = document.getElementById('guestEmail');
    const subjectInput = document.getElementById('guestSubject');
    const messageInput = document.getElementById('guestMessage');

    if (
        nameInput.value.trim() === '' ||
        lastnameInput.value.trim() === '' ||
        emailInput.value.trim() === '' ||
        subjectInput.value.trim() === '' ||
        messageInput.value.trim() === ''
    ) {
        alert('Wszystkie pola formularza muszą być wypełnione.');
        return false;
    }



    return sendMessage();
}