$(function (){
        'use strict';
        App.stopDefaultEvent();
        App.sidebarScroll();
        App.pageLoadBar();
    });


var checkForm = function(){
    
        var passwd=$("#passwd");
        var newpasswd=$("#newpasswd");
        var checkoutPasswd=$("#checkoutPasswd");
         if(passwd.val()==''){
			alert("密码不能为空");
			return false;
		}
        var numasc = 0;  
		var charasc = 0;  
		var otherasc = 0;
		if(newpasswd.val()==''){
			alert("新密码不能为空");
			return false;
		}else if(newpasswd.val().length<6  || newpasswd.val().length>16){
				 alert("密码最少6位，最多16位");
 				   return false;
 				 
 			   }else{
	   				for (var i = 0; i < newpasswd.val().length; i++) {  
	                   var asciiNumber = newpasswd.val().substr(i, 1).charCodeAt();  
	                   if (asciiNumber >= 48 && asciiNumber <= 57) {  
	                       numasc += 1;  
	                   }  
	                   if ((asciiNumber >= 65 && asciiNumber <= 90)||(asciiNumber >= 97 && asciiNumber <= 122)) {  
	                       charasc += 1;  
	                   }  
	                   
	               }  
	               if(0==numasc)  { 
	            	   alert("密码必须含有数字");
	                   return false;  
	               }else if(0==charasc){  
	            	   alert("密码必须含有字母");
	                   return false;  
	               }
 	   	}
			
			
		if(checkoutPasswd.val()==''){
			alert("确认密码不能为空");
			return false;
		}
		
		if(checkoutPasswd.val()==newpasswd.val()){
			passwd.val(hex_md5(passwd.val()));
			newpasswd.val(hex_md5(newpasswd.val()));
		}else{
		  alert("确认密码和新密码不一致，请重新输入");
		    return false;  
		 }
	
			
		return true; 
    };
    
    $('#js-tester').on('click', function(event){
		event.preventDefault();
		if(checkForm()){
		  $.ajax({            
	            type: "POST",
	            url:"updatePassWd!updatePassWd.action",
	            data:$("#updatepasswdss").serialize(),// formid
	            async: true,
	            error: function(textStatus, errorThrown) {
	                       alert(textStatus);
	                   },
	            success: function(data) {
	                if(data==1){
	                    alert("密码修改成功!");
	               	    window.location.href="loginU!loginU.action";
	               	 
	               }else {
	              	 alert("密码修改失败!");
	                }
	           }
         });
		}
		
	});
    
    
    
		
		function setTab(){
           if(event.keyCode==13)
           event.keyCode=9;
        }