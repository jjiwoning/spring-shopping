sessionStorage.removeItem('accessToken');
const form = document.getElementById('login-form');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    let loginRequest = {};
    for (const entry of formData.entries()) {
        const [key, value] = entry;
        loginRequest[key] = value;
    }

    // TODO: [2단계] 로그인 path에 맞게 변경
    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginRequest)
    }).then((response) => {
        if (!response.ok) {
            return response.json().then((data) => {
                throw new Error(data.message);
            });
        }
        return response.json();
    }).then((data) => {
        const {accessToken} = data;
        sessionStorage.setItem('accessToken', accessToken);
        window.location.href = '/';
    }).catch((error) => {
        alert(error.message);
    });

});
