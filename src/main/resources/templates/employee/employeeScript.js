function cancelFunction() {
    let productName = document.getElementById("productName").value;
    let imagePath = document.getElementById("imagePath").value;
    let quantity = document.getElementById("quantity").value;
    let price = document.getElementById("price").value;
    let description = document.getElementById("description").value;


    let text = "Czy na pewno chcesz anulować?\n";
    if (confirm(text) == true) {
        window.location.href='offer.html';
    } else {
       document.getElementById("productName").value = productName;
        document.getElementById("imagePath").value = imagePath;
        document.getElementById("quantity").value = quantity;
        document.getElementById("price").value = price;
        document.getElementById("description").value = description;

    }
}

function saveFunction(){
    let productName = document.getElementById("productName").value;
    let imagePath = document.getElementById("imagePath").value;
    let quantity = document.getElementById("quantity").value;
    let price = document.getElementById("price").value;
    let description = document.getElementById("description").value;
    if (productName.trim() === "") {
        alert("Proszę podać nazwę produktu.");
        return;
    }
    if (imagePath.trim() === "") {
        alert("Proszę wybrać zdjęcie");
        return;
    }
    if (quantity <= 0) {
        alert("Liczba produktów musi być większa od 0.");
        return;
    }
    if (price <= 0) {
        alert("Cena musi być większa od 0.");
        return;
    }
    if (description.trim() === "") {
        alert("Proszę wprowadzić opis produktu");
        return;
    }


    const modal = document.getElementById('myModal');
    modal.style.display = 'block';
}

function removeProduct(){
    let text = "Czy na pewno chcesz usunąć produkt?\n";
    if (confirm(text) == true) {
        const modal = document.getElementById('myModal');
        modal.style.display = 'block';
    }
    else{
        window.location.href='offer.html';
    }
    const modal = document.getElementById('myModal');
    modal.style.display = 'block';
}

function saveDev(){
    let name = document.getElementById("name").value;
    let lastname = document.getElementById("lastname").value;
    let street = document.getElementById("street").value;
    let houseNumber = document.getElementById("houseNumber").value;
    let apartmentNumber = document.getElementById("apartmentNumber").value;
    let zipCode = document.getElementById("zipCode").value;
    let city = document.getElementById("city").value;
    let status = document.getElementById("status").value;

    // Prosta walidacja dla przykładu - sprawdzenie, czy pole imienia nie jest puste
    if (name.trim() === "") {
        alert("Proszę podać imię.");
        return;
    }

    if (lastname.trim() === "") {
        alert("Proszę podać nazwisko.");
        return;
    }


    // Walidacja dla pola Ulica
    if (street.trim() === "") {
        alert("Proszę podać ulicę.");
        return;
    }

    // Walidacja dla pola Nr domu
    if (houseNumber.trim() === "") {
        alert("Proszę podać numer domu.");
        return;
    }

    // Walidacja dla pola Kod pocztowy
    let zipCodeRegex = /^\d{2}-\d{3}$/;
    if (!zipCodeRegex.test(zipCode)) {
        alert("Proszę podać poprawny kod pocztowy (np. 12-345).");
        return;
    }

    // Walidacja dla pola Miasto
    if (city.trim() === "") {
        alert("Proszę podać miasto.");
        return;
    }

    const modal = document.getElementById('myModal');
    modal.style.display = 'block';
}

function cancelDev(){
    let name = document.getElementById("name").value;
    let lastname = document.getElementById("lastname").value;
    let street = document.getElementById("street").value;
    let houseNumber = document.getElementById("houseNumber").value;
    let apartmentNumber = document.getElementById("apartmentNumber").value;
    let zipCode = document.getElementById("zipCode").value;
    let city = document.getElementById("city").value;
    let status = document.getElementById("status").value;

    let text = "Czy na pewno chcesz anulować?\n";
    if (confirm(text) == true) {
        window.location.href='deliveries.html';
    } else {
        document.getElementById("name").value = name;
        document.getElementById("lastname").value = lastname;
        document.getElementById("street").value = street;
        document.getElementById("houseNumber").value = houseNumber;
        document.getElementById("apartmentNumber").value = apartmentNumber;
        document.getElementById("zipCode").value = zipCode;
        document.getElementById("city").value = city;
        document.getElementById("status").value = status;

    }
}
function removeDelivery(){
    let text = "Czy na pewno chcesz usunąć dostawę?\n";
    if (confirm(text) == true) {
        const modal = document.getElementById('myModal');
        modal.style.display = 'block';
    }
    else{
        window.location.href='deliveries.html';
    }
    const modal = document.getElementById('myModal');
    modal.style.display = 'block';
}