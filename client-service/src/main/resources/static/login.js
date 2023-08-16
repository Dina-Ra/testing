let stompClient = null;

const loginElementId = "login";
const passwordElementId = "password";

const authenticate = () => {
    stompClient = Stomp.over(new SockJS('/gs-guide-websocket'));
    stompClient.connect({}, (frame) => {
        setConnected(true);

        const login = document.getElementById(loginElementId).value;
        const password = document.getElementById(loginElementId).value;

      // ?????????????????
    });
}