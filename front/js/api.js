const API_URL = 'http://localhost:8080';

async function loginProfessor(email, senha) {
    const response = await fetch(`${API_URL}/professores/login`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, senha })
    });
    return response.json();
}

async function criarTurma(nome) {
    const response = await fetch(`${API_URL}/turmas`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome })
    });
    return response.text();
}

async function listarTurmas() {
    const response = await fetch(`${API_URL}/turmas`);
    return response.json();
}

async function deletarTurma(id) {
    const response = await fetch(`${API_URL}/turmas/deletar/${id}`, {
        method: 'DELETE'
    });
    return response.text();
}

async function criarAtividade(nome, descricao, turmaId) {
    const response = await fetch(`${API_URL}/atividades`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, descricao, turma: { id: turmaId } })
    });
    return response.text();
}

async function listarAtividades() {
    const response = await fetch(`${API_URL}/atividades`);
    return response.json();
}

async function deletarAtividade(id) {
    const response = await fetch(`${API_URL}/atividades/deletar/${id}`, {
        method: 'DELETE'
    });
    return response.text();
}