document.getElementById('loginForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('passwordLogin').value;

    try {
        const data = await loginProfessor(email, senha);
        if (data.success) {
            localStorage.setItem('professorNome', data.nome);
            alert(data.message);
            window.location.href = 'html/principal.html';
        } else {
            alert(data.message);
        }
    } catch (error) {
        alert("Erro ao fazer login");
        console.error(error);
    }
});