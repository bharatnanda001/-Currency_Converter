async function convertCurrency() {
    let amount = document.getElementById('amount').value;
    let fromCurrency = document.getElementById('fromCurrency').value;
    let toCurrency = document.getElementById('toCurrency').value;
    let resultDiv = document.getElementById('result');
    
    if (amount && fromCurrency && toCurrency) {
        let response = await fetch(`/convert?amount=${amount}&from=${fromCurrency}&to=${toCurrency}`);
        let data = await response.json();

        if (data.success) {
            resultDiv.innerHTML = `${amount} ${fromCurrency} = ${data.convertedAmount} ${toCurrency}`;
        } else {
            resultDiv.innerHTML = "Conversion failed. Please try again.";
        }
    } else {
        resultDiv.innerHTML = "Please fill out all fields.";
    }
}
