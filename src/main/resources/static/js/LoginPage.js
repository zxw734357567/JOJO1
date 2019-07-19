/**
 * Created by Administrator on 2019/4/2.
 */
$(document).ready(function() {
  $("#login-button").click(function () {
      var data={
          username: $("#userName").val(),
          password: $("#password").val(),
      };

    debugger
    $.ajax({
      type: "POST",
      url: window.location.origin + "/api/jwt/login",
     contentType: 'application/json;charset=utf-8',
      dataType: "JSON",
      data: JSON.stringify(data),
      success: function (data) {
        debugger
          console.log(data)
        // $("#data").html(data.name + '的任务是' + data.task);
      },

    });
  })

})

