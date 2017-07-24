            var code = ""; 
			/* 生成验证码*/
			function createCode(){ 
				var str = ""; 
				var codeLength = 4;//验证码的长度      
				var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
				      
				for(var i=0;i<codeLength;i++) {
				       
				   var charIndex = Math.floor(Math.random()*57); 
				   str +=selectChar[charIndex]; 
//				   console.info(i+","+code.length);
				}      
				return str;
				
			}    
			$('#checkCode').html(createCode());
			code=$('#checkCode').html();
        /* 表单验证*/
        var isCheck=function(){
            var $user = $("#userNO"),
			    $password = $("#passwd");
            var verif= $("#input1").val().toUpperCase(); 
		    var codeToUp=code.toUpperCase();
//		    console.info(verif+"  ==   "+codeToUp);
		    if(verif.length<=0){
		       alert("请输入验证码！");
		       return false;
		    }else if(verif!=codeToUp){
		        alert("验证码输入错误！");      
		        $('#checkCode').html(createCode());    
		        return false; 
		    }
				if( $.trim( $user.val() ) == ''){
					alert("用户名不能为空");
					return false;
				}
				if( $.trim( $password.val())== '' ){
					alert("密码不能为空");
					return false;
				}
				return true;
        
        }
        
		function goMain(){
            if(isCheck()){
                $("#passwd").val(hex_md5( $("#passwd").val()));
                $.ajax({            
	            type: "POST",
	            url:"main!main.action",
	            data: $("#loginfor").serialize(),// formid
	            async: true,
	            dataType:"json",
	            error: function() {
	            	alert("登录失败！");
	             },
	            success: function(data) {
	            	 if(data==1){
	              		window.location.href='helpDeskUI/view/index.jsp'; 
	              	  }else if(data==0){
	              		  document.all.pak.innerHTML="用户名错误，或不存在！"; 
	              		  $("#passwd").val('');
	              		  $("#userNO").val('');
	              	  }else if(data==9){
	              		  alert("首次登陆需修改密码，谢谢配合！");
	              		  window.location.href="helpDeskUI/view/edit_passW.jsp";
	              	  }else{
	              		document.all.pak.innerHTML="密码错误！"; 
	              		 $("#passwd").val('');
	              	  }
	                 
	            	}
	               
	          	
	       });
            }
		}
		$('#again').on('click', function(){
			$('#checkCode').html(createCode());
		  });
		$(function (){
			
			$(document).on('keyup', function(event){
				var keycode = event.which;
				if( keycode == 13){
					goMain();
				}
			});
		});
//		function setTab(){
//           if(event.keyCode==13)
//           goMain();
//        }