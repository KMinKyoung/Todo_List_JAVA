const token = localStorage.getItem('auth_token');  // JWT 토큰
const sortSelect = document.getElementById('sort-select');

// 할 일 목록을 출력하는 함수
function loadTodos() {
    fetch('http://localhost:8080/todos/todos_Lookup', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            // 🔽 선택된 정렬 방식에 따라 data 배열 정렬
            const sortType = sortSelect.value;
            if (sortType === 'korean') {
                data.sort((a, b) => a.title.localeCompare(b.title, 'ko'));
            } else if (sortType === 'number') {
                data.sort((a, b) => a.id - b.id);
            } else if (sortType === 'english') {
                data.sort((a, b) => a.title.localeCompare(b.title, 'en'));
            }

            const todoListContainer = document.getElementById('todo-list');
            todoListContainer.innerHTML = ''; // 기존 목록을 초기화

            data.forEach(todo => {
                const todoElement = document.createElement('div');
                todoElement.classList.add('todo-item');
                todoElement.innerHTML = `
                <input type="checkbox" id="todo-${todo.id}" ${todo.status === 'COMPLETED' ? 'checked' : ''}>
                <label for="todo-${todo.id}">
                    <a href="../html/todo_detail.html?id=${todo.id}" class="todo-title-link">${todo.title}</a></label>
                <button onclick="deleteTodo(${todo.id})">Delete</button>
            `;
                todoListContainer.appendChild(todoElement);
            });
        })
        .catch(error => console.error('Error fetching todos:', error));
}

// 할 일 삭제 함수
function deleteTodo(id) {
    fetch(`http://localhost:8080/todos/${id}`, {
        method: 'DELETE',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        }
    })
        .then(() => {
            loadTodos();  // 삭제 후 할 일 목록을 다시 불러오기
        })
        .catch(error => console.error('Error deleting todo:', error));
}



document.addEventListener('DOMContentLoaded', function () {
    loadTodos();

    if (sortSelect) {
        sortSelect.addEventListener('change', loadTodos);
    }

    const logoutBtn = document.getElementById("logout-button");
    if (logoutBtn) {
        logoutBtn.addEventListener("click", function () {
            localStorage.removeItem("auth_token"); // 토큰 제거
            alert("로그아웃 되었습니다.");
            window.location.href = "../html/index.html"; // 로그인 페이지로 이동
        });
    }
});
