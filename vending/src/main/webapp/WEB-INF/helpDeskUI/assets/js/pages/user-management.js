/*
* @Author     : lilonglong
* @Date       : 2015/08/12
* @Version    : 0.1.0
* @Description: 运维平台
* @Dependence : jquery.js, app.js
* @Mail       : long_mailbox@sina.com
* @Reference  : http://codeguide.bootcss.com/
************************************************
************************************************
*/
var UserManagement = (function (window, $, document, undefined) {
   'use strict';
   //收缩高级查询
   var sign=$('#js_sign').val();
   if(sign==1){
	    $('.form-table').addClass("in");
   }else{
	    $('.form-table').removeClass("in");  
   }

   
   $("#findUserN").on('click',function(){
	   if($('.form-table').hasClass("in")){
			  $('#js_sign').val('1');
//			  alert("赋值："+$('#js_sign').val());
		   }else{
			  $('#js_sign').val('0'); 
//			  alert("赋值："+$('#js_sign').val());
		   }
       $("#js-search-criteria").submit();
	   
   });
   
   //清空
   $("#findUserInfo").on('click',function(){
	   $("#js-search-criteria  input[type=text]").val('');
	   $("#js-search-criteria select").val('');
   });
  
  
   //邮箱验证
   function checkEmail(str){
      var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
      if(re.test(str)){
   	   return true;
      }else{
          alert("eamil格式错误");
          return false;
      }
  }
 //校验手机号码
   function checkMobile(str) {
      var re = /^1\d{10}$/;
      if (re.test(str)) {
   	   return true;
      } else {
   	   alert("手机号码格式错误");
          return false;
      }
  }
   //校验内部分机号
   function checkP(str) {
      var re = /^\d{1,4}$/ ;
      if (re.test(str)) {
   	   return true;
      } else {
   	   alert("内部分机号格式错误");
          return false;
      }
  }
 /*1.如果是英文名,可以允许英文名字中出现空格
   2.英文名的空格可以是多个，但是不能连续出现多个
   3.汉字不能出现空格
   */
   function isCardName(s) 
   {
       var patrn = /^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/; 
       if(!patrn.exec(s))
       {
    	   alert("姓名格式错误！");
           return false;
       }
       return true;
   }
   //加载角色
		$.ajax({
			type:"post",
			url:"findRoles!findRoles.action",
			data:"",
			async:"false",
			dataType: "json",
			error:function(){
			     alert("加载理赔系统失败！");
			       },
			success : function(datas) {
					var options = "<option value='' selected='selected'>请选择</option>";
					for ( var i = 0; i < datas.length; i++) {
						options += "<option value='" + datas[i].roleName
								+ "'>" + datas[i].roleName + "</option>";
						}
						$("#systemName").html(options);
						$('#systemName').val($('#js_roleName').val());
						$("#role_role").html(options);//新增用户
							
					}
					});  
	//禁用（启用）
    function forbidden(id,status,currPage,userNo){
    	var userCode=$("#js-session-userNo").val();
    	if(userNo===userCode){
    		alert("此用户正在使用，不能被禁用！");
    	}else{
	      $.ajax({            
			  type: "POST",
			  url:"updateStatus!updateStatus.action",
			  data:"userInfo.id="+id+"&userInfo.status="+status+"&userInfo.userNo="+userNo,
			  async: true,
			  error: function(XMLHttpRequest, textStatus, errorThrown) {
			              alert(XMLHttpRequest.status);
			              alert(XMLHttpRequest.readyState);
			              alert(textStatus);
			        },
			  success: function(data) {
			         if(data=="1"){
			            alert('操作成功!');
			            location.href="userCenter!userCenter.action?currPage="+currPage;
			          }else if(data==404){
			             alert('你好，由于您长时间没有操作，现需重新登录!'); 
			             window.location.href="loginU!loginU.action";
				      }else{
			              alert('操作失败!');
			           }
			         }
			        });
    	}
		       
    }
  
 
    
    return {
        addUserDialog: function (){
        	
            if( !$().dialog) { 
                 throw new Error('addUserDialog 方法: 依赖 jquery-ui.js'); 
            }
            var $dialog  = $('#js-add-user-dialog'),
                $btn     = $('#js-add-user-btn'),
                $fom     = $dialog.find('form');
            
           
            var isCheck = function (){
               var email=$("#email").val();
              
               var userNo=$("#userNo").val();
   			   var userName=$("#userName").val();
   			   var mobilePhone=$("#mobilePhone").val();
   			   var roleName=$("#role_role").val();
   			   var password=$("#passwd");
   			   var phone=$("#phone").val();
   			  
 			   
 			   if( $.trim(userNo) == ''){
 		         	alert("请填写工号!");
 		        	return false;
 		        }else if(userNo.length>8){
 		        	alert("工号过长！");
 		        	return false;
 		        }
 		        if( $.trim(userName) == ''){
 		         	alert("请填写姓名!");
 		        	return false;
 		        }else if(userName.length<20){
 		        	if(!isCardName(userName))
 		        		return false;	
 		        }else{
 		        	alert("姓名过长!");
 		        	return false;
 		        }
 		       if( $.trim(phone) == ''){
		         	alert("请填写内部分机!");
		        	return false;
		        }else{
		        	if(!checkP(phone))
		        		return false;
		        }
 		       
 		       if( mobilePhone.length>0){
		        	if(!checkMobile(mobilePhone))
		        		return false;
		        }
 		       
 		        if( $.trim(email) == ''){
		         	alert("请填写email!");
		        	return false;
		        }else if(email.length>0){
          	      if(!checkEmail(email))
          		   return false;//调用 
          	   
               }
 		       
 		        if($.trim(roleName) == ''){
 		        	alert("请选择角色!");
 		        	return false;
 		        }
 		       var numasc = 0;  
 		       var charasc = 0;  
 		       var otherasc = 0; 
 		       if($.trim(password.val())=='' || password.val().length==0){
 	   				 alert("请填写密码!");
 			        	return false;
 	   			   }else if(password.val().length<6  || password.val().length>16){
 	   				 alert("密码最少6位，最多16位");
	   				   return false;
 	   				 
 	   			   }else{
	 	   				for (var i = 0; i < password.val().length; i++) {  
	 	                   var asciiNumber = password.val().substr(i, 1).charCodeAt();  
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
	 	               }else{  
	 	            	  password.val(hex_md5(password.val()));  
	 	               }  
 	   				  
 	   			   }
 		       return true;
 	          	
            };
           
           
            
             $dialog.dialog({
                autoOpen: false,
                height: 340,
                width: 780,
                resizable: false,
                maxWidth: 780,
                modal: true,
                title: '新增用户',
                buttons: {
                    '新增': function() {
                   if( isCheck() ) {
         			  		$.ajax({            
         		             type: "POST",
         		             url:"addUser!addUser.action",
         		             data: $("#add").serialize(),// formid
         		             //async: true,
         		             error: function(XMLHttpRequest, textStatus, errorThrown) {
         		                        alert(XMLHttpRequest.status);
         		                        alert(XMLHttpRequest.readyState);
         		                        alert(textStatus);
         		              },
         		             success: function(data) {
         		                 if(data==1){
         		                 	alert('新增成功!');
         		                 	window.location.href='userCenter!userCenter.action'; 
         		                 		
         		                 }else if(data==404){
         		                	 alert('你好，由于您长时间没有操作，现需重新登录!'); 
         		                	 window.location.href="loginU!loginU.action";
         			              }  else if(data==2){
         		                 	alert('账号已存在，请重新输入！');
         		                 	$("#userNo").val('');
         		                 	$("#passwd").val('');
         		                 }else{
         		                	alert('新增失败！'); 
         		                 }
         		           	}
         		        });
         	            }
                    },
                    '返回': function() {
                       $dialog.dialog('close');
                    }
                }
            });
            
            $btn.on('click', function(){
                
                $dialog.dialog('open');
            });

        },
        
        editDialog: function (){
        	
        
            if( !$().dialog) { 
                 throw new Error('editDialog 方法: 依赖 jquery-ui.js'); 
            }
            
            var $dialog  = $('#js-edit-user-dialog'),
                $form    = $dialog.find('form');
            
           
            
           
            
           function back(id,currPage){
        	   var page=currPage;
            	 $.ajax({
     				cache:true,//缓存不会将界面清空
     				type: "POST",
     				url: "getUserNew!getUserNew.action?userInfo.id="+id,
     				dataType: "json",
     				error: function(requests){
     					alert("信息读取失败");
     				},
     				success:function(data){
     					$("#js_page").val(page);
     					$("#js_user_no").val(data.userNo);
     					$("#js_user_name").val(data.userName);
     					$("#js_telephone").val(data.phone);
     					$("#js_mailbox").val(data.email);
     					$("#mobile_phone").val(data.mobilePhone);
     					$("#js_id").val(data.id);
     					$.ajax({
     						type:"post",
     						url:"findRoles!findRoles.action",
     						data:"",
     						async:"false",
     						dataType: "json",
     						error:function(){
     						     alert("加载理赔系统失败！");
     						       },
     						success : function(datas) {
     							var options;
 								for ( var i = 0; i < datas.length; i++) {
 									options += "<option value='" + datas[i].roleName
 											+ "'>" + datas[i].roleName + "</option>";
 								}
     										
     							$("#js_role_name").html(options);
     										
     							$("#js_role_name").val(data.roleName);
     										
     						}
     					}); 
     							  
     				}
     			});
            }
           //修改验证
           var checkUser= function(){
        	   var passwd=$("#passWord");
        	   var userName=$("#js_user_name").val();
        	   var mobilePhone=$("#mobile_phone").val();
        	   var phone=$("#js_telephone").val();
        	   var email=$("#js_mailbox").val();
        	   var role=$("#js_role_name").val();
        	   
        	  
        	   if( $.trim(userName) == ''){
		         	alert("请填写姓名!");
		        	return false;
		        }else if(userName.length<20){
 		        	if(!isCardName(userName))
 		        		return false;	
 		        }else{
 		        	alert("姓名过长!");
 		        	return false;
 		        }
		       if( $.trim(phone) == ''){
		         	alert("请填写固定电话!");
		        	return false;
		        }
		        if( mobilePhone.length>0){
		        	if(!checkMobile(mobilePhone))
		        		return false;
		        }
		        if( $.trim(email) == ''){
		         	alert("请填写email!");
		        	return false;
		        }else if(email.length>0){
           	        if(!checkEmail(email))
           		    return false;//调用 
                }
		        if($.trim(role) == ''){
		        	alert("请选择角色!");
		        	return false;
		        }
		        var numasc = 0;  
	 		    var charasc = 0;  
	 		    var otherasc = 0; 
		       if(passwd.val().length==0){
		    	   
		       }else if(passwd.val().length<6  || passwd.val().length>16){
	   				 alert("密码最少6位，最多16位");
	   				   return false;
	   				 
	   			   }else{
	 	   				for (var i = 0; i < passwd.val().length; i++) {  
	 	                   var asciiNumber = passwd.val().substr(i, 1).charCodeAt();  
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
	 	               }else{  
	 	            	  passwd.val(hex_md5(passwd.val()));  
	 	               } 
	   			   }
           	   
           	   return true;
           };
           
        
            $dialog.dialog({
                autoOpen: false,
                height: 340,
                width: 780,
                resizable: false,
                maxWidth: 780,
                modal: true,
                title: '修改用户',
                buttons: {
                    '修改': function() {
                   
                    if(checkUser()){
                    	$.ajax({            
       		             type: "POST",
       		             url:"updateUser!updateUser.action",
       		             data: $("#updateUser").serialize(),// formid
       		             async: true,
       		             error: function(XMLHttpRequest, textStatus, errorThrown) {
       		                        alert(XMLHttpRequest.status);
       		                        alert(XMLHttpRequest.readyState);
       		                        alert(textStatus);
       		              },
       		             success: function(data) {
       		            	
       		                 if(data==1){
       		                 	alert('修改成功!');
       		                 	window.location.href='userCenter!userCenter.action?currPage='+$("#js_page").val(); 
       		                 		
       		                 } else if(data==404){
    		                	 alert('你好，由于您长时间没有操作，现需重新登录!'); 
    		                	 window.location.href="loginU!loginU.action";
    			              } else if(data==9){
    		                 	alert('此用户已被使用，故姓名、角色不会被修改，其他信息已修改成功，请知晓！');
    		                 	window.location.href='userCenter!userCenter.action?currPage='+$("#js_page").val(); 
    		                 }else{
    		                	 alert('修改失败!');
    		                 }
    		           	    }
    		             });
                    }
                    	
                    },
                    '返回': function() {
                       $dialog.dialog('close');
                    }
                }
            });
            
            App.$content.find('.panel-flat').on('click', 'tbody .btn-sm', function(event){
            	
            	var $target = $(event.target);
            	
            	if( $target.hasClass('js-btn-edit')  ) {
            		var arr=$target.attr('data-id').split(',');
            		
            		back(arr[0],arr[1] );
            		$dialog.dialog('open');
            		
            	} else if(  $target.hasClass('js-forbidden-btn') ) {
            		var arr = $target.attr('data-id').split(',');
            		forbidden(arr[0],arr[1],arr[2],arr[3]);
       
            	} 
            	
            	
    
            });
        },
       //分页
        goPage: function (currPage){
       	var $forms = $('#js-search-criteria');
       		$forms.append("<input type='hidden' name='currPage' value='"+currPage+" '>");
       		$forms[0].submit();   
        }
   };
})(window, jQuery, document);