var RoleManagement = (function (){
    'use strict';
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
				var options = "<option value='' selected='selected'>角色</option>";
				for ( var i = 0; i < datas.length; i++) {
					options += "<option value='" + datas[i].roleName
							+ "'>" + datas[i].roleName + "</option>";
					}
					$("#systemName").html(options);
					
						
				}
				}); 
  //禁用（启用）
    function forbidden(id,status,currPage,roleName){
    	
	      $.ajax({            
			  type: "POST",
			  url:"updateRoleStatus!updateRoleStatus.action",
			  data:"roleInfo.id="+id+"&roleInfo.status="+status+"&roleInfo.roleName="+roleName,
			  async: true,
			  error: function(XMLHttpRequest, textStatus, errorThrown) {
			              alert(XMLHttpRequest.status);
			              alert(XMLHttpRequest.readyState);
			              alert(textStatus);
			        },
			  success: function(data) {
			         if(data==1){
			            alert('操作成功!');
			            location.href="roleCenter!roleCenter.action?currPage="+currPage;
			         } else if(data==404){
			            	  alert('你好，由于您长时间没有操作，现需重新登录!'); 
			            	  window.location.href="loginU!loginU.action";
			        }else if(data==2){
			        	 alert('此角色已被使用，不能被禁用!');
			        }else {
			        
			                alert('操作失败!');
			                 }
			           	}
			        });
		       
    } 
    
    return {
    	
        addUserDialog: function (){
            var $dialog = $('#js-add-role-dialog'),
                $btn    = $('#js-add-role-btn'),
                $form   = $dialog.find('form');
            
            var ischeck=function(){
             	
        		var role=$("#roleName").val();
        		 if( $.trim(role) == '' &&  role.length == 0){
                 	alert("请填写角色名称!");
                	return false;
                }else if(role.length>50){
                	alert("角色名称过长!");
                	return false;
                }
        		 //校验是否勾选模块
                var checkObjs = document.getElementsByName("roleInfo.systemCode");
                var check=0;
                for(var i=0;i<checkObjs.length;i++) {
                		if(checkObjs[i].checked) {
                			check=check+1;
                		}
                	}
                if(check==0){
                	alert("至少要选择一个理赔系统！");
        			return false;
                }
                var checkOb = document.getElementsByName("roleInfo.authorityCode");
                var is=0;
                for(var i=0;i<checkOb.length;i++) {
                		if(checkOb[i].checked) {
                			is=is+1;
                		}
                	}
                if(is==0){
                	alert("至少要选一个权限!");
        			return false;
                }
                return true;
         }

            $dialog.dialog({
                autoOpen: false,
                height: 450,
                width: 420,
                maxWidth: 420,
                modal: true,
                title: '新增角色',
                buttons: {
                    '新增': function() {
                    	if( ischeck() ) {
        			  		$.ajax({            
        		             type: "POST",
        		             url:"addRoles!addRoles.action",
        		             data: $("#addRole").serialize(),// formid
        		             async: true,
        		             error: function(XMLHttpRequest, textStatus, errorThrown) {
        		                        alert(XMLHttpRequest.status);
        		                        alert(XMLHttpRequest.readyState);
        		                        alert(textStatus);
        		              },
        		             success: function(data) {
        		                 if(data==1){
        		                 	alert('新增成功!');
        		                 	window.location.href='roleCenter!roleCenter.action'; 
        		                 		
        		                 }else if(data==404){
        		                	 alert('你好，由于您长时间没有操作，现需重新登录!'); 
        		                	 window.location.href="loginU!loginU.action";
        			              } else if(data==9){
        		                 	 alert('此角色名称已被使用，请重新命名，谢谢！');
        		                 	 $("#roleName").val('');
        		                 }else{
        		                	 alert('新增失败!'); 
        		                 }
        		           	}
        		        });
        	            }
        			
        			
                    },
                    '关闭': function() {
                       $dialog.dialog('close');
                    }
                }
            });

            $btn.on('click', function(){
                $dialog.dialog('open');
            });
        },
        editRoleDialog: function (){
            if( !$().dialog) { 
                 throw new Error('editRoleDialog 方法: 依赖 jquery-ui.js'); 
            }
            var $dialog  = $('#js-edit-role-dialog'),
                $form    = $dialog.find('form');
            
            function back(id,currPage){
            	var page=currPage;
            	$.ajax({
    				cache:true,//缓存不会将界面清空
    				type: "POST",
    				url: "getRoles!getRoles.action?roleInfo.id="+id,
    				dataType: "json",
    				error: function(requests){
    				alert("信息读取失败");
    					},
    				success:function(data){
    				   $("#js_page").val(page);
    				   $('.js-checkbox').attr('checked',false);
    				   $("#js_id").val(data.id);
    				   $("#js_role_name").val(data.roleName);
    				   var systemCode=data.systemCode;
    				   var sys=systemCode.split(',');
    				   var autorityCode=data.authorityCode;
    				   var arr=autorityCode.split(',');
    				   
    				   $.each($form.find('.js-checkbox'), function (i, ele){
    				    	 for(var s=0;s<sys.length;s++){
     		                    if($(ele).val()==sys[s]){
     		                    	$(ele).prop('checked',true);
     		                    } 
     		                    
     		                 }
    				    	 for(var i=0;i<arr.length;i++){
     		                    if($(ele).val()==arr[i]){
     		                    	$(ele).prop('checked',true);
     		                    	
     		                    }
     		                }
    						   
    					   });
    				  
    					}
    					}); 
            }
            //理赔系统全选和全不选
            $('.js-check-all').click(function(){
            	
        	   var subUlCheckbox = $(this).parent()
        		                        .children('ul')
        		                        .find('input[type="checkbox"]');

        	   if( this.checked){
        		   subUlCheckbox.prop('checked', true);  
    		   } else {
    			   subUlCheckbox.prop('checked', false);
    		   }
        	           		                        		
            });
          //任务中心全选和全不选
            $('.js-check-plo').click(function(){
            	
        	   var subUlCheckbox = $(this).parent()
        		                        .children('ul')
        		                        .find('input[type="checkbox"]');

        	   if( this.checked){
        		   subUlCheckbox.prop('checked', true);  
    		   } else {
    			   subUlCheckbox.prop('checked', false);
    		   }
        	           		                        		
            });
          //权限管理全选和全不选
            $('.js-check-aut').click(function(){
            	
        	   var subUlCheckbox = $(this).parent()
        		                        .children('ul')
        		                        .find('input[type="checkbox"]');

        	   if( this.checked){
        		   subUlCheckbox.prop('checked', true);  
    		   } else {
    			   subUlCheckbox.prop('checked', false);
    		   }
        	           		                        		
            });
          //值班全选和全不选
            $('.js-check-watch').click(function(){
            	
        	   var subUlCheckbox = $(this).parent()
        		                        .children('ul')
        		                        .find('input[type="checkbox"]');

        	   if( this.checked){
        		   subUlCheckbox.prop('checked', true);  
    		   } else {
    			   subUlCheckbox.prop('checked', false);
    		   }
        	           		                        		
            });
            
            var ischeckUp=function(){
        		var role=$("#js_role_name").val();
        		 if( $.trim(role) == '' &&  role.length == 0){
                 	alert("请填写角色名称!");
                	return false;
                }else if(role.length>50){
                	alert("角色名称过长!");
                	return false;
                }
        		 //校验是否勾选模块
                var checkObjs = document.getElementsByName("roleInfo.systemCode");
                var check=0;
                for(var i=0;i<checkObjs.length;i++) {
                		if(checkObjs[i].checked) {
                			check=check+1;
                		}
                	}
                if(check==0){
                	alert("至少要选择一个理赔系统！");
        			return false;
                }
                var checkOb = document.getElementsByName("roleInfo.authorityCode");
                var is=0;
                for(var i=0;i<checkOb.length;i++) {
                		if(checkOb[i].checked) {
                			is=is+1;
                		}
                	}
                if(is==0){
                	alert("至少要选一个权限!");
        			return false;
                }
                return true;
         }
            
            $dialog.dialog({
                autoOpen: false,
                height: 450,
                width: 420,
                maxWidth: 420,
                modal: true,
                title: '修改角色',
                buttons: {
                    '修改': function() {
                    	
                    if(ischeckUp()){
                    	$.ajax({            
       		             type: "POST",
       		             url:"updateRoles!updateRoles.action",
       		             data: $("#updateRole").serialize(),// formid
       		             async: true,
       		             error: function(XMLHttpRequest, textStatus, errorThrown) {
       		                        alert(XMLHttpRequest.status);
       		                        alert(XMLHttpRequest.readyState);
       		                        alert(textStatus);
       		              },
       		             success: function(data) {
       		                 if(data=="1"){
       		                 	
       		                 	alert('修改成功!');
       		                 	window.location.href='roleCenter!roleCenter.action?currPage='+$("#js_page").val(); 
       		                 		
       		                 }else if(data==404){
       		                	 alert('你好，由于您长时间没有操作，现需重新登录!'); 
       		                	 window.location.href="loginU!loginU.action";
       			              } else {
       		                 	alert('修改失败!', 2, 8);
       		                	
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
       	var $forms = $('#js-froms');
       		$forms.append("<input type='hidden' name='currPage' value='"+currPage+" '>");
       		$forms[0].submit();   
        }
    };
})();