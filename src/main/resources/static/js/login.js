document.getElementById('login-form').addEventListener('submit', async function (e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const loginData = { email, password };

    try {
        const response = await fetch('/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginData),
            credentials: 'include'
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`로그인 실패: ${errorText}`);
        }

        const data = await response.json();
        localStorage.setItem("auth_token", data.token); // ✅ 통일된 키로 저장
        console.log("저장된 토큰:", data.token);

        window.location.href = "../html/todo.html";
    } catch (error) {
        alert(`오류가 발생했습니다: ${error.message}`);
    }
});
