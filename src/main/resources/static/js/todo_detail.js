const token = localStorage.getItem("auth_token");
const params = new URLSearchParams(window.location.search);
const todoId = params.get("id");

fetch(`http://localhost:8080/todos/todos_Lookup/${todoId}`, {
    headers: {
        'Authorization': `Bearer ${token}`
    }
})
    .then(response => {
        if (!response.ok) throw new Error("조회 실패");
        return response.json();
    })
    .then(todo => {
        document.getElementById("todo-detail").innerHTML = `
        <h2>${todo.title}</h2>
        <p><strong>Description:</strong> ${todo.description}</p>
        <p><strong>Status:</strong> ${todo.status}</p>
        <p><strong>Created At:</strong> ${new Date(todo.createdAt).toLocaleString()}</p>
        

    `;
        document.getElementById("edit-button").addEventListener("click", ()=>{
            window.location.href=`../html/todo_edit.html?id=${todoId}`;

        });
        document.getElementById("back-button").addEventListener("click", () => {
            window.location.href = "todo.html";
        });

    })
    .catch(err => {
        alert("할 일을 불러오는 데 실패했습니다.");
        console.error(err);
    });
