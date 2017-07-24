 $(function (){
        Boxs.init();
    });
    //分页
    function goPage(currPage){
         //alert(currPage);
			$("#forms").append("<input type='hidden' name='currPage' value='"+currPage+" '>");
			$("#forms").submit();   
	}
	//普通查询
	function formsubmit1(){
	   $(".form-search-advanced input[type=text]").val(''); 
	   $(".form-search-advanced select").val('');
	   
	   $("#forms").submit();
	}
   //高级查询
   function formsubmit(){
         $("#js-dropdown-menu input[type=text]").val(''); 
	     $("#js-dropdown-menu select").val('');
	     $("#forms").submit();           
        }
 //清空表单查询值
    function cleanFormValue(){
		$("#forms input[type=text]").val(''); 
		$("#forms select").val('');
        }
     	//收起
   	 function cleanAdvance(){
        $("#js-advanced-search").trigger("click");//模拟单击操作        
     }
    //禁用（启用）
    function forbidden(id,status){
     
        //alert(id+" * "+status);
	      $.ajax({            
			  type: "POST",
			  url:"updateStatus!updateStatus.action",
			  data:"userInfo.id="+id+"&userInfo.status="+status,
			  async: true,
			  error: function( textStatus, errorThrown) {
			              alert(textStatus);
			        },
			  success: function(data) {
			         if(data=="1"){
			           alert('操作成功!');
			            location.href="userCenter!userCenter.action";
			              }else if(data==404){
			                	 alert('你好，由于您长时间没有操作，现需重新登录!'); 
			                	 window.location.href="loginU!loginU.action";
				              }  else {
			                alert('操作失败!');
			                	
			                 }
			           	}
			        });
		       
    }
      
    //加载角色
	$(document).ready(function(){
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
			        //alert(datas);
					var options = "<option value='' selected='selected'>请选择</option>";
					for ( var i = 0; i < datas.length; i++) {
						options += "<option value='" + datas[i].roleName
								+ "'>" + datas[i].roleName + "</option>";
						}
						$("#systemName").html(options);
						
						$("#role_role").html(options);//新增用户
							
					}
					}); 
				}); 
	    //修改
		function back(id){
			// 如果没有加载 layer 组件，停止代码执行
         	if( !$.layer ) { return false; } 
			var $modal = $('#js-register-modal');
			var layerObje = $.layer({
			    type: 1,
			    title: false,
			    area: ['560', 'auto'],
			    shade: [0.5, '#000'],
			    border: [0], //去掉默认边框
			    // shade: [0], //去掉遮罩
			    closeBtn: [0, false], //去掉默认关闭按钮
			    move: '.modal-header',
			    page: {
			    	dom: $modal
			    }
			});
			 $.ajax({
				cache:true,//缓存不会将界面清空
				type: "POST",
				url: "getUserNew!getUserNew.action?userInfo.id="+id,
				dataType: "json",
				error: function(requests){
				alert("信息读取失败");
					},
				success:function(data){
				 //alert(data.id);
					$("#js_user_no").val(data.userNo);
					$("#js_user_name").val(data.userName);
					$("#js_telephone").val(data.phone);
					$("#js_mailbox").val(data.email);
					//$("#js_role_name").val(data.roleName);
					$("#js_user_code").val(data.userCode);
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
						        //alert(datas);
							    var options;
								for ( var i = 0; i < datas.length; i++) {
									options += "<option value='" + datas[i].roleName
											+ "'>" + datas[i].roleName + "</option>";
									}
										
										$("#js_role_name").html(options);//
										
										$("#js_role_name").val(roleName);
										
									}
									}); 
							  
					}
					});
						 
			 function updateUsers(){
			  		$.ajax({            
		             type: "POST",
		             url:"updateUser!updateUser.action",
		             data: $("#updateUser").serialize(),// formid
		             async: true,
		             error: function(textStatus, errorThrown) {
		                        alert(textStatus);
		              },
		             success: function(data) {
		                 if(data=="1"){
		                 	layer.close(layerObje);
		                 	layer.msg('修改成功!', 2, 1);
		                 	window.location.href='userCenter!userCenter.action'; 
		                 		
		                 }else if(data==404){
		                	 layer.msg('你好，由于您长时间没有操作，现需重新登录!', 2, 8); 
		                	 window.location.href="loginU!loginU.action";
			              } else {
		                 	layer.msg('修改失败!', 2, 8);
		                	$("#js-save_1").attr("disabled",false);
		                 }
		           	}
		        });
	            }
			
			  // 模态框底部按钮处理
       		$modal.on('click', function(event){
				var $target = $(event.target);
				
				if( $target.hasClass('modal-close') ){
					layer.close(layerObje);
				} else if( $target.hasClass('modal-submit_1') ){
					updateUsers();
				}
			});
		}
		//新增
		function add(){
			// 如果没有加载 layer 组件，停止代码执行
         	if( !$.layer ) { return false; } 
			var $modal = $('#js-register-modal-x');
			var layerObje = $.layer({
			    type: 1,
			    title: false,
			    area: ['560', 'auto'],
			    shade: [0.5, '#000'],
			    border: [0], //去掉默认边框
			    // shade: [0], //去掉遮罩
			    closeBtn: [0, false], //去掉默认关闭按钮
			    move: '.modal-header',
			    page: {
			    	dom: $modal
			    }
			});
			function checkModal(){
			   var userNo=$("#userNo").val();
			   var userName=$("#userName").val();
			    var userName=$("#userCode").val();
			   var password=$("#passwd");
			   password.val(hex_md5('123456'));
			   var check = true;
			   if( $.trim(userNo) == '' && userNo.length == 0){
		         	layer.msg("请填写工号!", 2, 8);
		        	return false;
		        }
		        if( $.trim(userName) == '' && userName.length == 0){
		         	layer.msg("请填写姓名!", 2, 8);
		        	return false;
		        }
		        if( $.trim(userCode) == '' && userCode.length == 0){
		         	layer.msg("请填写账号!", 2, 8);
		        	return false;
		        }
		        //校验账号和工号是否已注册
	          	$.ajax({
					type : "POST",
					url :"checkout!checkout.action",
					data:$("#add").serialize(),// formid
					dataType : "json",
					async: false,
					success:function(datas){
	            		if( datas === 1 ){
	           				layer.msg("账号已注册！", 2, 8);
	           				check = false;
	           				//document.getElementById("policy_no_1").value="";
	            		} else {
	            			check = true;
	            		}
	            		
					}
				});
		        
		        if( check ) {
	            	$("#js-save").attr("disabled",true);	
			  		$.ajax({            
		             type: "POST",
		             url:"addUser!addUser.action",
		             data: $("#add").serialize(),// formid
		             async: true,
		             error: function( textStatus, errorThrown) {
		                        alert(textStatus);
		              },
		             success: function(data) {
		                 if(data=="1"){
		                 	layer.close(layerObje);
		                 	layer.msg('新增成功!', 2, 1);
		                 	window.location.href='userCenter!userCenter.action'; 
		                 		
		                 }else if(data==404){
		                	 layer.msg('你好，由于您长时间没有操作，现需重新登录!', 2, 8); 
		                	 window.location.href="loginU!loginU.action";
			              }  else {
		                 	layer.msg('新增失败!', 2, 8);
		                	$("#js-save").attr("disabled",false);
		                 }
		           	}
		        });
	            }
			
			}
			
			  // 模态框底部按钮处理
       		$modal.on('click', function(event){
				var $target = $(event.target);
				
				if( $target.hasClass('modal-close') ){
					layer.close(layerObje);
				} else if( $target.hasClass('modal-submit') ){
					checkModal();
				}
			});
		}
		$('#y1').on('click', function (event){
			event.preventDefault();
			add();
		});