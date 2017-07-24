  
    $(function (){
        Boxs.init();
    });
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
					var options = "<option value='' selected='selected'>角色</option>";
					for ( var i = 0; i < datas.length; i++) {
						options += "<option value='" + datas[i].roleName
								+ "'>" + datas[i].roleName + "</option>";
						}
						$("#systemName").html(options);
						
						//$("#js_subcompany_id_1").html(options);
							
					}
					}); 
				});
	//禁用（启用）
    function forbidden(id,status){
	      $.ajax({            
			  type: "POST",
			  url:"updateRoleStatus!updateRoleStatus.action",
			  data:"roleInfo.id="+id+"&roleInfo.status="+status,
			  async: true,
			  error: function( textStatus, errorThrown) {
			              alert(textStatus);
			        },
			  success: function(data) {
			         if(data=="1"){
			           alert('操作成功!');
			            location.href="roleCenter!roleCenter.action";
			              } else if(data==404){
			            	  alert('你好，由于您长时间没有操作，现需重新登录!'); 
			            	  window.location.href="loginU!loginU.action";
			              }else {
			                alert('操作失败!');
			                 }
			           	}
			        });
		       
    } 
     //分页
    function goPage(currPage){
         //alert(currPage);
			$("#forms").append("<input type='hidden' name='currPage' value='"+currPage+" '>");
			$("#forms").submit();   
	}
    //普通查询
	function formsubmit(){
	   $("#forms").submit();
	}
	//修改
		function back(id,status){
		   
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
				url: "getRoles!getRoles.action?roleInfo.id="+id,
				dataType: "json",
				error: function(requests){
				alert("信息读取失败");
					},
				success:function(data){
				//alert( $('.js-checkbox').length);
				   $('.js-checkbox').attr('checked',false);
				   $("#js_id").val(data.id);
				   $("#js_role_name").val(data.roleName);
				   //alert(data.authorityCode);
				   var systemCode=data.systemCode;
				   var sys=systemCode.split(',');
				   var autorityCode=data.authorityCode;
				   var arr=autorityCode.split(',');
	               // $('.js-checkbox').attr('checked',true);
				   
	               $('.js-checkbox').each(function(){
	            	   
	            		for(var s=0;s<sys.length;s++){
		                    if($(this).val()==sys[s]){
		                   	 	//alert("sys"+sys[s]);
		                    	$(this).attr('checked',true);
		                    	break;
		                    }
		                 }
		                 
	            	});
	            	$('.js-checkbox').each(function(){ 
	            	 for(var i=0;i<arr.length;i++){
		                    if($(this).val()==arr[i]){
		                   	 	//alert("sys"+sys[s]);
		                    	$(this).attr('checked',true);
		                    	break;
		                    }
		                    }
	            	
	                });
							  
					}
					}); 
						 
			 function updateRole(){
			  		$.ajax({            
		             type: "POST",
		             url:"updateRoles!updateRoles.action",
		             data: $("#updateRole").serialize(),// formid
		             async: true,
		             error: function( textStatus, errorThrown) {
		                        alert(textStatus);
		              },
		             success: function(data) {
		                 if(data=="1"){
		                 	layer.close(layerObje);
		                 	layer.msg('修改成功!', 2, 1);
		                 	window.location.href='roleCenter!roleCenter.action'; 
		                 		
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
					updateRole();
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
				var check = false;
				var role=$("#roleName").val();
				 if( $.trim(role) == '' &&  role.length == 0){
		         	layer.msg("请填写角色名称!", 2, 8);
		        	return true;
		        }
				 //校验是否勾选模块
	            var checkObjs = document.getElementsByName("roleInfo.systemCode");
	            for(var i=0;i<checkObjs.length;i++) {
	            		if(checkObjs[i].checked) {
	            			check=true;
	            			break;
	            		}
	            	}
	            var checkOb = document.getElementsByName("roleInfo.authorityCode");
	            for(var i=0;i<checkOb.length;i++) {
	            		if(checkOb[i].checked) {
	            			check=true;
	            			break;
	            		}
	            	}
			
		        if( check ) {
		        
	            	$("#js-save").attr("disabled",true);	
			  		$.ajax({            
		             type: "POST",
		             url:"addRoles!addRoles.action",
		             data: $("#addRole").serialize(),// formid
		             async: true,
		             error: function( textStatus, errorThrown) {
		                        alert(textStatus);
		              },
		             success: function(data) {
		                 if(data=="1"){
		                 	layer.close(layerObje);
		                 	layer.msg('新增成功!', 2, 1);
		                 	window.location.href='roleCenter!roleCenter.action'; 
		                 		
		                 }else if(data==404){
		                	 layer.msg('你好，由于您长时间没有操作，现需重新登录!', 2, 8); 
		                	 window.location.href="loginU!loginU.action";
			              } else {
		                 	layer.msg('新增失败!', 2, 8);
		                	$("#js-save").attr("disabled",false);
		                 }
		           	}
		        });
	            }else{
	               alert("理赔系统和权限每个都至少要选一个！");
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