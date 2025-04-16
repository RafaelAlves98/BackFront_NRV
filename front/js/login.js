function login () {
    const email = document.getElementById('loginemail').value;
    const senha = document.getElementById('loginsenha').value;

    fetch('http://localhost:8080/professor/login', {
        method: 'POST',
        headers: { 
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email,senha })
    })
    
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert(data.message);  
            window.location.href = 'dashboard.html';
        } else {
            alert(data.message);  
        }
    })
    .catch(error => {
        alert("Erro ao fazer login");
        console.log(error);
    });
}
