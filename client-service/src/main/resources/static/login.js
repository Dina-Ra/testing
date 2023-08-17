let stompClient = null;

const verificationsTableElementId = "verificationsTable";
const loginElementId = "login";
const passwordElementId = "password";

const setConnectedAuthenticate = (connected) => {
    const authenticateBtn = document.getElementById("authenticate");

    authenticateBtn.disabled = connected;
    const testTable = document.getElementById(testTableElementId);
    verificationsTableElementId.hidden = !connected;
}

const authenticate = () => {
    stompClient = Stomp.over(new SockJS('/gs-guide-websocket'));
    stompClient.connect({}, (frame) => {
        setConnectedAuthenticate(true);

        const login = document.getElementById(loginElementId).value;
        const password = document.getElementById(loginElementId).value;

      // ?????????????????
    });
}

const setConnectedNewUser = (connected) => {
    const newUserBtn = document.getElementById("newUser");

    newUserBtn.disabled = connected;
    const testTable = document.getElementById(testTableElementId);
    verificationsTableElementId.hidden = !connected;
}

const newUser = () => {
    stompClient = Stomp.over(new SockJS('/gs-guide-websocket'));
    stompClient.connect({}, (frame) => {
        setConnectedNewUser(true);

        const login = document.getElementById(loginElementId).value;
        const password = document.getElementById(loginElementId).value;

      // ?????????????????
    });
}

const logout = () => {
    const disconnect = () => {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        setConnectedAuthenticate(false);
        setConnectedNewUser(false);
    }
}