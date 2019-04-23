/**
 * Created by Administrator on 2019/4/2.
 */
$(document).ready(function() {
  $("#login-button").click(function () {
    debugger
    $.ajax({
      type: "POST",
      url: window.location.origin + "/user/login",
     //contentType: 'application/json;charset=utf-8',
      dataType: "JSON",
      data: {
        "username": $("#userName").val(),
       "password": $("#password").val(),
      },
      success: function (data) {
        // $("#data").html(data.name + '的任务是' + data.task);
      },

    });
  })

})

