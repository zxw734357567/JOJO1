/**
 * Created by Administrator on 2019/4/2.
 */
$("#login-button").click(function(){
  debugger
  $.ajax({
    type:"post",
    url:"/user/login",
    dataType:"json",
    data:{
      'userName':$("#userName").val(),
      'password':$("#password").val(),
    },
    success:function(data){
     // $("#data").html(data.name + '的任务是' + data.task);
    },
    error:function(jqXHR){
     // $("#data").html("发生错误:"+jqXHR.status);
    }
  });
});
