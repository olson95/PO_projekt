document.getElementById('applyFilter').addEventListener('click', function() {
    // Tutaj dodaj kod obsługujący naciśnięcie przycisku "Ok"
    // Na razie zostawmy go pustym
    console.log('Przycisk "Ok" został naciśnięty');
});


function addToCart(){
        const modal = document.getElementById('myModal');
        modal.style.display = 'block';

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
    let email = document.getElementById("guestEmail").value;
    let subject = document.getElementById("guestSubject").value;
    let message = document.getElementById("guestMessage").value;

    let text = "Czy na pewno chcesz anulować?\n";
    if (confirm(text) === true) {
        window.location.href ='shop.html';
    } else {
        document.getElementById("guestName").value = name;
        document.getElementById("guestEmail").value = email;
        document.getElementById("guestSubject").value = subject;
        document.getElementById("guestMessage").value = message;
    }
}
