const token = localStorage.getItem('auth_token');  // JWT 토큰

document.getElementById('add-todo-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;

    const todoData = {
        title: title,
        description: description,
        status: "TODO"  // 서버에서 허용하는 값으로 수정
    };

    fetch('http://localhost:8080/todos', {
        method: 'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(todoData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('서버 오류 또는 인증 실패');
            }
            return response.json();
        })
        .then(() => {
            window.location.href = '../html/todo.html';  // 할 일 추가 후 목록 페이지로 이동
        })
        .catch(error => console.error('Error adding todo:', error));
});
