document.addEventListener('DOMContentLoaded', function() {
    // 示例：绑定表单提交事件
    const form = document.querySelector('form');
    if (form) {
        form.addEventListener('submit', function(e) {
            e.preventDefault();
            const formData = new FormData(form);
            fetch('/plants/add', {
                method: 'POST',
                body: formData
            })
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    // 处理响应数据
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });
    }
    const socket = io();

    // 监听从服务器发送的消息
    socket.on('message', function(message) {
        console.log('收到消息: ', message);
        // 在这里更新您的界面，显示新消息
    });

    // 示例：发送消息
    // 假设您有一个表单用于发送消息
    document.querySelector('#message-form').addEventListener('submit', function(e) {
        e.preventDefault();
        const message = document.querySelector('#message-input').value;
        socket.emit('sendMessage', message);
    });
});
