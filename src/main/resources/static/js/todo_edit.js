const token = localStorage.getItem('auth_token');
const params = new URLSearchParams(window.location.search);
const todoId = params.get("id");

fetch(`http://localhost:8080/todos/todos_Lookup/${todoId}`, {
    headers: { 'Authorization': `Bearer ${token}` }
})
    .then(response => response.json())
    .then(todo => {
        document.getElementById("title").value = todo.title;
        document.getElementById("description").value = todo.description;
        document.getElementById("status").value = todo.status;
    })
    .catch(err => console.error("할 일 로딩 실패:", err));

document.getElementById("edit-form").addEventListener("submit", function (e) {
    e.preventDefault();

    const updatedTodo = {
        title: document.getElementById("title").value,
        description: document.getElementById("description").value,
        status: document.getElementById("status").value
    };

    fetch(`http://localhost:8080/todos/${todoId}`, {
        method: "PUT",
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedTodo)
    })
        .then(res => {
            if (!res.ok) throw new Error("수정 실패");
            alert("수정 완료!");
            window.location.href = `todo_detail.html?id=${todoId}`;
        })
        .catch(err => {
            console.error(err);
            alert("수정 중 오류 발생");
        });
});
