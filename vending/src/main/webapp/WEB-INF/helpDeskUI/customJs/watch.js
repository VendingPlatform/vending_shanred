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
	   $("#forms").submit();
	}
	//删除
	function deleteW(id){
		alert(id);
		$.ajax({
			cache:true,//缓存不会将界面清空
            type: "POST",
            url:"deleteWatch!deleteWatch.action?rosterInfo.id="+id,
           
            error: function( textStatus, errorThrown) {
                       alert(textStatus);
             },
            success: function(data) {
                if(data=="1"){
                	alert('删除成功!');
                	window.location.href='getWatch!getWatch.action'; 
                		
                }else if(data==404){
                	alert('你好，由于您长时间没有操作，现需重新登录!'); 
            	 window.location.href="loginU!loginU.action";
              }  else {
                	alert('删除失败!');
                }
          	}
		});
	}
     //加载值班人员
	$(document).ready(function(){
		$.ajax({
			type:"post",
			url:"getWatchUsers!getWatchUsers.action",
			data:"",
			async:"false",
			dataType: "json",
			error:function(){
			     alert("加载值班人员失败！");
			       },
			success : function(datas) {
			        //alert(datas);
					var options = "<option value='' selected='selected'>请选择</option>";
					for ( var i = 0; i < datas.length; i++) {
						options += "<option value='" + datas[i].userName
								+ "'>" + datas[i].userName + "</option>";
						}
						$("#js_user_name").html(options);//上午值班选值
						$("#js_user_name1").html(options);//下午值班选值
						$("#js_user_name2").html(options);//查询条件选值	
						
						
					}
					}); 
				}); 
	//安排
	function handleModal (){
			// 如果没有加载 layer 组件，停止代码执行
         	if( !$.layer ) { return false; } 
			var $modal = $('#js-register-modal-s');
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
			   var watchDate=$("#watchDate").val();
			   var amWatch=$("#amWatch").val();
			   var pmWatch=$("#pmWatch").val();
			   var check = true;
			   if( $.trim(watchDate) == '' && watchDate.length == 0){
		         	layer.msg("请选择日期!", 2, 8);
		        	return false;
		        }
		        /*
		        if( $.trim(amWatch) == '' && amWatch.length == 0 && $.trim(pmWatch) == '' && pmWatch.length == 0){
		         	layer.msg("请安排值班人!", 2, 8);
		        	return false;
		        }*/
		        if( check ) {
		       // alert("%%%%%%%%%%%%%%%");
	            	$("#js-save").attr("disabled",true);	
			  		$.ajax({            
		             type: "POST",
		             url:"addWatchUsers!addWatchUsers.action",
		             data: $("#add").serialize(),// formid
		             async: true,
		             error: function( textStatus, errorThrown) {
		                        alert(textStatus);
		              },
		             success: function(data) {
		                 if(data=="1"){
		                 	layer.close(layerObje);
		                 	layer.msg('成功!', 2, 1);
		                 	window.location.href='getWatch!getWatch.action'; 
		                 		
		                 }else if(data==404){
		                	 layer.msg('你好，由于您长时间没有操作，现需重新登录!', 2, 8); 
		                	 window.location.href="loginU!loginU.action";
			              }  else {
		                 	layer.msg('失败!', 2, 8);
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
			handleModal();
		});
        //修改
		function updateW(id){
		
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
				url: "getWatchNew!getWatchNew.action?rosterInfo.id="+id,
				dataType: "json",
				error: function(requests){
				alert("信息读取失败");
					},
				success:function(data){
				  //alert(data.id);
					$("#js_watch_date").val(data.watchDate);
					$("#js_id").val(data.id);
					var amWatch=data.amWatch;
					var pmWatch=data.pmWatch;
					
				    $.ajax({
						type:"post",
						url:"getWatchUsers!getWatchUsers.action",
						data:"",
						async:"false",
						dataType: "json",
						error:function(){
						     alert("加载值班人员失败！");
						       },
						success : function(datas) {
						        //alert(datas);
						        var options;
								for ( var i = 0; i < datas.length; i++) {
									options += "<option value='" + datas[i].userName
											+ "'>" + datas[i].userName + "</option>";
									
									
								}
									
									$("#js_am_watch").html(options);//
									$("#js_pm_watch").html(options);//
									$("#js_am_watch").val(amWatch);
									$("#js_pm_watch").val(pmWatch);
								}
								}); 
							  
					}
					});
					 
			   function updateWatch(){
			  		$.ajax({            
		             type: "POST",
		             url:"updateWatchUsers!updateWatchUsers.action",
		             data: $("#updateWSe").serialize(),// formid
		             async: true,
		             error: function( textStatus, errorThrown) {
		                        alert(textStatus);
		              },
		             success: function(data) {
		                 if(data=="1"){
		                 	layer.close(layerObje);
		                 	layer.msg('修改成功!', 2, 1);
		                 	window.location.href='getWatch!getWatch.action'; 
		                 		
		                 }else if(data==404){
		                	 layer.msg('你好，由于您长时间没有操作，现需重新登录!', 2, 8); 
		                	 window.location.href="loginU!loginU.action";
			              }  else {
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
					updateWatch();
				}
			});
		}
		