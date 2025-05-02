document.getElementById('login-form').addEventListener('submit', async function (e) {
    e.preventDefault(); // 폼 기본 제출 막기

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const loginData = {
        email: email,
        password: password
    };

    try {
        const response = await fetch('/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginData),
            credentials: 'include' // ✅ 이거 없으면 CORS 때문에 403 뜰 수 있어요
        });


        if (!response.ok) {
            const errorText = await response.text(); // JSON이 아닐 수도 있으니
            throw new Error(`로그인 실패: ${errorText}`);
        }

        const data = await response.json(); // 이제 안전하게 JSON 파싱
        localStorage.setItem("token", data.token);
        window.location.href = "../html/todo.html";
    } catch (error) {
        alert(`오류가 발생했습니다: ${error.message}`);
    }

});
