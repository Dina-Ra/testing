let stompClient = null;

const verificationsTableElementId = "verificationsTable";
const loginElementId = "login";
const passwordElementId = "password";

const subjectElementId = "subject";
const testTableElementId = "testTable";

const subjectNewTestElementId = "subjectNewTest";
const textNewTestElementId = "textNewTest";

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

const testing = () => {
    const subject = document.getElementById(subjectElementId).value;
    stompClient.subscribe(`/topic/response.${subject}`, (text) => showTestTable(JSON.parse(text.body)));

}

const showTestTable = (test) => {
    const testTable = document.getElementById(testTableElementId);

    let questionRow = testTable.insertRow(-1);
    let questionCell = questionRow.insertCell(0);
    let question = document.createTextNode(test.text);
    questionCell.appendChild(question);

   // как реализовать вывод вопроса и 4х вариантов ответа, ума не приложу
    let answerRow = testTable.insertRow(0);
    let answerCell = answerRow.insertCell(1);
    let answer = document.createTextNode(test.text);
    answerCell.appendChild(answer);
}

const addTest = () => {
    const subjectNewTest = document.getElementById(subjectNewTestElementId).value;
    const textNewTest = document.getElementById(textNewTestElementId).value;

    // как получить массив ответов?????

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