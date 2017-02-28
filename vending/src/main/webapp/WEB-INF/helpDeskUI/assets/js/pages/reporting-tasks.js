/*
 * javascript 闭包
 */
var ReportingTasks = (function(window, $, document, undefined) {
	'use strict';	

	
	// 查询条件处理
	var searchForm = function() {
		
		// 加载理赔系统
		$
				.ajax({
					type : "post",
					url : "getSystem!getSystem.action",
					data : "",
					async : false,
					dataType : "json",
					error : function() {
						alert("加载系统平台失败！");
					},
					success : function(datas) {

						var options="<option value=''> 请选择 </option>" ;
						for ( var i = 0; i < datas.length; i++) {
							options += "<option value='" + datas[i].systemName
									+ "'>" + datas[i].systemName + "</option>";
						}

						$("#systemName2").html(options); // 新建加载
						$("#systemName2").val(datas[0].systemName); // 新建加载
				
						$("#systemName1").html(options); // 高级查询加载
						$("#systemName1").val(datas[0].systemName); // 高级查询加载
					}
				});

		// 加载问题类型
		$
				.ajax({
					type : "post",
					url : "getProblemType!getProblemType.action",
					data : "",
					async : false,
					dataType : "json",
					error : function() {
						alert("加载问题类型失败！");
					},
					success : function(datas) {

						var options="<option value=''> 请选择 </option>" ;
						for ( var i = 0; i < datas.length; i++) {
							options += "<option value='"
									+ datas[i].problemTypeName + "'>"
									+ datas[i].problemTypeName + "</option>";
						}

						$("#js-add-problemType").html(options); // 新建加载问题类型
						$("#js-add-problemType").val(datas[0].problemTypeName);// 新建加载问题类型
						$("#js-select-problemType").html(options); // 高级查询加载问题类型
						$("#js-select-problemType").val(datas[0].problemTypeName); // 高级查询加载问题类型
				
					}
				});		
		//timeRange();
		var $forms = $("#js-search-criteria"), 
		    $searchBtn = $forms.find('.btn-info'),
		    $clearBtn = $forms.find('.btn-default');
		var sign=$('#js_sign').val();
		   if(sign==1){
			    $('.form-table').addClass("in");
		   }else{
			    $('.form-table').removeClass("in");  
		   } 
		   
		$searchBtn.on('click', function() {
	      var taskId=$('#js-select-taskId').val()			
		  var taskIdLength=taskId.length	
			if(taskIdLength>10){
				alert("任务编号长度不能超过10");
				return false;
			}
	      if($('.form-table').hasClass("in")){
			  $('#js_sign').val('1');
		   }else{
			  $('#js_sign').val('0'); 
		   }	
	       
	        $forms[0].submit();
	        
		});
		
		$clearBtn.on('click', function() {
			$forms[0].reset();
			$("#js-select-submitter1").val('');
			$("#js-submit-satr-date").val('');  
			$("#js-submit-end-date").val('');
			$("#js-select-taskId").val('');
		
		});

	};
	   
	//修改的显示图片
	var initImge = function(ajaxData) {
	
	var imgCount 	= ajaxData.filesSum, 
			imageNames  = ajaxData.imageNames,
			imagePath,
			i, 
			$imgGallery = $('#js-img-gallery-new'),
			$imgWrapper = $('.img-yunying'),
			$img 		= $imgWrapper.children('img'),
			$imgZoom 	= $imgWrapper.find('.pull-left.btn'),
			$imgRemove  = $imgWrapper.find('.pull-right.btn');
			
		var imgCountWei = ajaxData.filesSumWei, 
			imageNamesWei  = ajaxData.imageNamesWei,
			iWei, 
			$imgGalleryWei = $('#js-img-gallery-yunwei'),
			$imgWrapperWei = $('.img-yunwei'),
			$imgWei 		= $imgWrapperWei.children('img'),
			$imgZoomWei 	= $imgWrapperWei.find('.pull-left.btn');

	       for (i = 0; i < $img.length; i++){
	        	if(i<imgCount){
	        		$($img[i]).prop("src","showImg!showImg.action?imagePath=" + "yunying" + "&imageName=" + imageNames[i] + "&taskId="+ ajaxData.taskId);
		        	$($imgZoom[i]).prop("href","ajaxShowImage!ajaxShowImage.action?imagePath=" + "yunying" + "&imageName=" + imageNames[i] +  "&taskId="+ ajaxData.taskId);	        	
		        	$($imgRemove[i]).attr('id',imageNames[i]);
		        	$($imgRemove[i]).attr('taskid',ajaxData.taskId);
		        	$($imgWrapper[i]).addClass('img-cover-hover');
		        	$($imgWrapper[i]).addClass('img-cover-hover-yunying');
	        	}else{
	        		$($img[i]).prop('src','helpDeskUI/assets/images/placeholder.png');
		        	$($imgZoom[i]).prop("href",'#');
		        	$($imgRemove[i]).attr('id',imageNames[i]);
		        	$($imgRemove[i]).attr('taskid',ajaxData.taskId);
		        	$($imgWrapper[i]).removeClass('img-cover-hover');
		        	$($imgWrapper[i]).removeClass('img-cover-hover-yunying');
	        	}
	        	
	        }

           for (iWei = 0; iWei <$imgWei.length; iWei++){
	        	if(iWei<imgCountWei){
	        		$($imgWei[iWei]).prop("src","showImgWei!showImgWei.action?imagePath=" + "yunwei" +"&imageNamesWei=" + imageNamesWei[iWei] + "&taskId="+ ajaxData.taskId);
		        	$($imgZoomWei[iWei]).prop("href","ajaxShowImage!ajaxShowImage.action?imagePath=" + "yunwei" +"&imageNamesWei=" + imageNamesWei[iWei] + "&taskId="+ ajaxData.taskId);	        			        
		        	$($imgWrapperWei[iWei]).addClass('img-cover-hover');
                         		        	
	        	}else{
	        		$($imgWei[iWei]).prop('src','helpDeskUI/assets/images/placeholder.png');		        		     
		        	$($imgWrapperWei[iWei]).removeClass('img-cover-hover');
		        	}		  
	        }	
	        
    
     	$imgRemove.off('click');
        $imgRemove.on('click', function(event) {
        	event.preventDefault();
        	
        	var r = window.confirm("确定要删除这张图片吗？");
    		if (!r) {
    			return false ;
    		}
    			var $this = $(this),ind=$this.attr('id');
    			
    			$.ajax({
    				type : "POST",
    				url : "deleteImg!deleteImg.action?imageName="
    						+ ind + "&taskId="
    						+ $this.attr('taskid'),
    				data : "",
    				async : true,
    				error : function(XMLHttpRequest, textStatus,
    						errorThrown) {
    					alert(XMLHttpRequest.status);
    					alert(XMLHttpRequest.readyState);
    					alert(textStatus);
    				},
    				success : function(datas) {
    					if ('true'==datas) {
    						var taskid=$('#js_taskInfo_taskId').text();				  		   																				
    						$('#'+taskid).trigger('click');   			
    						return true;
    					} else {
    						alert("删除图片失败!");
    						return false;
    					}
    				}
    			});
		});

	};

	 var addFileInputUpdate = function (){
		 var i;
		 var imglen          =$('.img-cover-hover-yunying').length;
		/* var html            = '<input type="file" class="margin-bottom-lg js-update-imgs"  name="taskInfo.files" >';*/
		 
		 var html = '<div class="margin-bottom form-inline inline-false ">'+
		 ' <input type="file" class="margin-bottom-lg js-input-imgs form-control" name="taskInfo.files" id="js-update-inputfile-first" />'+
		 '<button type="button" class="btn btn-danger margin-bottom-lg form-control js-imageName-clear" style="margin-left: 3px;" onclick="ReportingTasks.clearAddress(this)">'+	
		 '<i class="fa fa-close"></i>'+
		 '</button>	'+
		 '</div>' ;
		 
		 var $FileInputUpdate=$('#js-add-file'),
		     $input          =$('div.form-inline>input'),
		     $divFormInline=$('.inline-false');
		 
		 for(i=1;i<$divFormInline.length;i++){
			 $($divFormInline[i]).remove();
		 }
		 if(imglen==4){
			 $('#js-update-imgadd-div').hide();
		 }else if(imglen<4){
			 $('#js-update-imgadd-div').show();			
			 for(i=0;i<4-imglen-1;i++){
			 $('.form-inline:last-child').after(html);  
			 }				
		 } 
		 
	 };	 
  
	   var ischeckadd = function (){
			var  imgLen , i;
       	    var  imgName, imgsName ;
       	    var  $inputImgs= $(".js-input-imgs");  
       	    imgLen=$inputImgs.length;
		   for(i=0;i<imgLen;i++){
	  				imgName=$($inputImgs[i]).val();
	  				if(imgName!=''){
	  					imgsName=imgName.substr(imgName.length-4);           		  				
	  					if(imgsName==".png" ||imgsName==".PNG"|| imgsName==".jpg"||imgsName==".JPG"){ 	  					
	  					}else{
	  						alert("请上传png或者jpg格式的图片");
	  						return false;
	  					}
	  				}	
 	       }
		   return true;
		   
	   };	   
	   var ischeckupdate = function (){
			var  imgLen , i;
      	    var  imgName, imgsName ;
      	    var  $inputImgs= $(".js-update-imgs");  
      	    imgLen=$inputImgs.length;
		   for(i=0;i<imgLen;i++){
	  				imgName=$($inputImgs[i]).val();
	  				if(imgName!=''){
						imgsName=imgName.substr(imgName.lastIndexOf('.'));
						if(imgsName==".png" || imgsName==".jpg"||imgsName==".PNG" || imgsName==".JPG"){ 	  					
	  					}else{
	  						alert("请上传png或者jpg格式的图片");
	  					return false;
	  					}	
	  				}	
	       }
		   return true;
		   
	   };
	   var timeRange = function (){
	        if (!$().datepicker) {
	            throw new Error('datepickerModule 方法: 依赖 jquery-ui.js');
	        }	        
	        var $form = $('#js-submit-satr-date'), $to   = $('#js-submit-end-date');

	         $form.datepicker({
	               changeMonth : true,
	               changeYear : true,
	              
	               numberOfMonths : 1,
	               showOn:  'button',
	               buttonImageOnly: true,
	               buttonText: '选择开始时间',
	               onClose : function(selectedDate) {
	                       $to.datepicker("option", "minDate", selectedDate);
	               }
	          });   	        	            
	            $to.datepicker({
	               changeMonth : true,
	               changeYear : true,
	               numberOfMonths : 1,
	                showOn:  'button',
	               buttonImageOnly: true,
	               buttonText: '选择结束时间',
	               onClose : function(selectedDate) {
	                       $form.datepicker("option", "maxDate", selectedDate);
	               }
	          });
	    };
	
   //之前的显示照片
	var initImg = function(ajaxData) {	
		var imgCount = ajaxData.filesSum , str = '', i, $imgGallery = $('#js-img-gallery');		
		for (i = 0; i < imgCount; i++) {
			var v = ajaxData.taskId + "-" + i;
			str += '<div class="row">' + '<div class="col-md-3">'
					+ "<img alt='' class='" + v
					+ "' src='showImg!showImg.action?index=" + i + "&taskId="
					+ ajaxData.taskId + "'/>" + "<button type='button'  id='" + i
					+ "' taskid='" + ajaxData.taskId + "' class='btn btn-default btn-move-img' title='p-title' >删除</button>" + '</div>' + '</div>';

		}	
		$imgGallery.html(str);

		$imgGallery.find('.btn-move-img').on('click', function() {
					var $this = $(this);
					$.ajax({
						type : "POST",
						url : "deleteImg!deleteImg.action?index="
								+ $this.attr('id') + "&taskId="
								+ $this.attr('taskid'),
						data : "",
						async : true,
						error : function(request) {
							alert("Connection error");
						},
						success : function(datas) {
							
							if (datas) {
								var r = window.confirm("确定要删除这张图片吗？");
								if (!r) {
									return;
								}
								$this.parent().remove();
								alert("删除图片成功");
							} else {
								alert("删除图片失败!");
							}
						}
					});
				});

	};

	var viewTrInfo = function() {
		var $table = App.$content.find('.table-task-lists');
		$table
				.on(
						'click',
						'tbody tr',
						function() {														
							var taskId = $(this).children('td').first();
							//清除所有行的背景色
							$(this).parent().find('tr').css('background-color','');
							//设置当前点击行的背景色
							$(this).css('background-color','lightblue');
							//清空所有checkbox
							$(this).parent().find('tr td input').prop('checked',false);
							//选中当前行中checkbox
							$(this).last('td').find('input').prop('checked',true);
							//重置表单
							$('#js-update-task-form')[0].reset();														
							$
									.ajax({
										cache : true,
										// 缓存不会将界面清空
										type : "POST",
										url : "getTaskNew1!getTaskNew1.action?taskInfo.taskId="
												+ taskId.text(),
										dataType : "json",
										error : function(requests) {
											alert("getTaskNew信息读取失败");
										},
										success : function(data) {
											
											$("#js_taskInfo_taskTitle").html(
													data.taskTitle);
											$("#js_taskInfo_taskId").html(
													data.taskId);											
											
											$("#systemName").val(
													data.settlement);
											$("#js_taskInfo_priority").val(
													data.priority);
											$("#js_taskInfo_submissionTime")
													.val(data.submissionTime);
											
											if(data.processTime==null){
											  $("#js_taskInfo_processTime")
											       .html("");
											}else{
											   $("#js_taskInfo_processTime")
											       .html(data.processTime);
											}
																						
											$("#js-update-problemType").val(
													data.problemType);											
											if(data.handleUser==null){
												$("#js_taskInfo_handleUser").html("");
											}else{
												$("#js_taskInfo_handleUser").html(
														data.handleUser);												
											}																						
											$("#js_taskInfo_submitter").html(
													data.submitter);																					
											 $("#js_id").val(data.taskId);											
											 if(data.processState==1){	/*新建*/											 
												 $('#js-update-btn').attr('disabled',false); 
											     $('#js-update-submit-btn').attr('disabled',false);
											     $('#js-update-back-btn').attr('disabled',true);											     
											     $('#js-update-cancel-btn').attr('disabled',false);
											     $('#js-add-btn').attr('disabled',false); 
											     $('#js-submit-btn').attr('disabled',false); 
											     $('#js-delete-btn').attr('disabled',false); 											    
											     $('#js-close-btn').attr('disabled',true); 
											 }else if(data.processState==7){/*待处理*/
												 
												 $('#js-update-btn').attr('disabled',true); 
											     $('#js-update-submit-btn').attr('disabled',true);
											     $('#js-update-back-btn').attr('disabled',true);
											     $('#js-update-cancel-btn').attr('disabled',true);
											     $('#js-add-btn').attr('disabled',false); 
											     $('#js-submit-btn').attr('disabled',true); 
											     $('#js-delete-btn').attr('disabled',true); 											    
											     $('#js-close-btn').attr('disabled',true); 
											 }else if(data.processState==5){/*处理中*/
												 
												 $('#js-update-btn').attr('disabled',true); 
											     $('#js-update-submit-btn').attr('disabled',true);
											     $('#js-update-back-btn').attr('disabled',true);
											     $('#js-update-cancel-btn').attr('disabled',true);
											     $('#js-add-btn').attr('disabled',false); 
											     $('#js-submit-btn').attr('disabled',true); 
											     $('#js-delete-btn').attr('disabled',true); 											    
											     $('#js-close-btn').attr('disabled',true); 
											 }else if(data.processState==3){/*已处理*/
												 $('#js-update-btn').attr('disabled',false); 
											     $('#js-update-submit-btn').attr('disabled',false);
											     $('#js-update-back-btn').attr('disabled',false);
											     $('#js-update-cancel-btn').attr('disabled',false);
											     $('#js-add-btn').attr('disabled',false); 
											     $('#js-submit-btn').attr('disabled',false); 
											     $('#js-delete-btn').attr('disabled',true); 											    
											     $('#js-close-btn').attr('disabled',false); 
											 }else if(data.processState==2){/*运维打回*/
												 $('#js-update-btn').attr('disabled',false); 
											     $('#js-update-submit-btn').attr('disabled',false);
											     $('#js-update-back-btn').attr('disabled',true);
											     $('#js-update-cancel-btn').attr('disabled',true);
											     $('#js-add-btn').attr('disabled',false); 
											     $('#js-submit-btn').attr('disabled',false); 
											     $('#js-delete-btn').attr('disabled',true); 											    
											     $('#js-close-btn').attr('disabled',false); 
											 }else if(data.processState==6){/*运营打回*/
												 $('#js-update-btn').attr('disabled',true); 
											     $('#js-update-submit-btn').attr('disabled',true);
											     $('#js-update-back-btn').attr('disabled',true);
											     $('#js-update-cancel-btn').attr('disabled',true);
											     $('#js-add-btn').attr('disabled',false); 
											     $('#js-submit-btn').attr('disabled',true); 
											     $('#js-delete-btn').attr('disabled',true); 											    
											     $('#js-close-btn').attr('disabled',true); 
											 }else{/*关闭*/
												 $('#js-update-btn').attr('disabled',true); 
											     $('#js-update-submit-btn').attr('disabled',true);
											     $('#js-update-back-btn').attr('disabled',true);
											     $('#js-update-cancel-btn').attr('disabled',true);
											     $('#js-add-btn').attr('disabled',false); 
											     $('#js-submit-btn').attr('disabled',true); 
											     $('#js-delete-btn').attr('disabled',true); 											    
											     $('#js-close-btn').attr('disabled',true); 
											 }
										// 加载问题类型
											$
													.ajax({
														type : "post",
														url : "getProblemType!getProblemType.action",
														data : "",
														async : "false",
														dataType : "json",
														error : function() {
															alert("加载问题类型失败！");
														},
														success : function(
																datas) {

															var options = "", i, $problemType = $('#js-update-problemType');

															for (i = 0; i < datas.length; i++) {

																options += "<option value='"
																		+ datas[i].problemTypeName
																		+ "'>"
																		+ datas[i].problemTypeName
																		+ "</option>";
															}

														      
															 $problemType
														            	.html(options);
												
															  $problemType
																	.val(data.problemType);

														}
													});
											// 加载理赔系统
											$
													.ajax({
														type : "post",
														url : "getSystem!getSystem.action",
														data : "",
														async : "false",
														dataType : "json",
														error : function() {
															alert("加载系统平台失败！");
														},
														success : function(
																datas) {

															var options = "", i, $systemName = $('#systemName');

															for (i = 0; i < datas.length; i++) {
																options += "<option value='"
																		+ datas[i].systemName
																		+ "'>"
																		+ datas[i].systemName
																		+ "</option>";
															}

															$systemName
																	.html(options);
															$systemName
																	.val(data.settlement);
														}
													});
										    initImge(data);//最新的 显示图片
										    addFileInputUpdate(); 
										    //隐藏删除标签
										    if($('#js-update-submit-btn').attr("disabled")=="disabled"){
										             $('.shanchu').hide();
										    }else{  
										    	$('.shanchu').show();
										    	}										    										    	 										    
										
										    //流程记录显示										
											var html = "";
											var htmls="";
											var ht="";
											for ( var i = 0; i < data.processRecord.length; i++) {
												html = html
														+ "<tr><td>"
														+ data.processRecord[i].handleUser
														+ "</td><td>"
														+ data.processRecord[i].handleTime
														+ "</td>  <td>"
														+ data.processRecord[i].remarks
														+ "</td> </tr>";
																								        
											}
											var statur=data.processState;											
											if(statur==7 || statur==5 || statur==4 || statur==6){
												var flag=false;
												//问题描述（历史）
												for ( var i = data.processRecord.length-1; i >=0; i--) {
													if(data.processRecord[i].problemDescription!=null){
														flag=data.processRecord[i].problemDescription==data.problemDescription;
														htmls+="<textarea class='margin-bottom form-control'  readonly='true'>"
														        +data.processRecord[i].problemDescription
														        +"</textarea>";
													}
												}
												if(!flag){
													htmls+="<textarea class='margin-bottom form-control'  readonly='true'>"
												        +data.problemDescription
												        +"</textarea>";
												}
											}else{
												var flag=false;
												//问题描述（历史）
												for ( var i = data.processRecord.length-1; i >=0; i--) {
													if(data.processRecord[i].problemDescription!=null){
														flag=data.processRecord[i].problemDescription==data.problemDescription;
														htmls+="<textarea class='margin-bottom form-control'  readonly='true'>"
														        +data.processRecord[i].problemDescription
														        +"</textarea>";
													}
												}
												var v=flag?'':data.problemDescription;
												htmls+="<textarea class='margin-bottom form-control' name='taskInfo.problemDescription' id='js_taskInfo_problemDescription' rows='5'>"
											        +v
											        +"</textarea>";
											}																						
											//处理意见
											for ( var i = data.processRecord.length-1; i >=0; i--) {
												if(data.processRecord[i].hangleSuggestion!=null){
													ht+="<textarea class='margin-bottom form-control'  readonly='true'>"
													        +data.processRecord[i].hangleSuggestion
													        +"</textarea>";
												}
											}											
											$('#js-taskInfo-processRecord').html(html);
											$("#js_problemDescription").html(htmls);
											$("#js-handleSuggestion").html(ht);
										}
									});
						});
	};
    
	var infoScorll = function() {
		App.$content.find('.task-info-scorll').slimScroll({
			 //滚动条滚动到顶部或底部时是否允许页面滚动,默认false
	          allowPageScroll: false,
	          size: '6px',
	          railVisible:false,
	          // 滚动条距离位置
	          distance:'0',
	          railColor:'#000',	          
	          alwaysVisible: false,
	          //滚动条背景轨迹透明度,默认0.2
	          // railOpacity: 0.2,
	          height: '490'

		});
	};	
	return {
		init : function() {
			searchForm();		
			infoScorll();
			viewTrInfo();
			timeRange();
		},

		addFileInputAdd : function(id) {
			if (id.length && typeof id === 'string') {
				$(id).on('click', '.btn.btn-default', function(event) {
					var $this = $(this);				
					var html = '<div class="form-inline detach">'+
						 '<input type="file" class="margin-bottom-lg js-input-imgs form-control"  name="taskInfo.files">'+
						 '<button type="button" class="btn btn-danger margin-bottom-lg form-control js-imageName-clear" style="margin-left: 3px;"  onclick="ReportingTasks.clearAddress(this)">'+	
						 '<i class="fa fa-close"></i>'+
						 '</button>	'+
						 '</div>' ;
					if ($this.parent().children().children('input').size() == 4) {
						$this.attr('disabled', true);
					} else {
						$this.prev().after(html);
					}
				});
			}
			
		},
	   checkAll :function(){
		   $("#checkAll").click(function() {
			    $("input[name='taskInfo.status']").prop("checked", this.checked);
			  });
	   },		  
	   //回显状态值
	   backStatus : function(){
		  var strStatus = $("#js-select-statusBack").val().split(',');		  
		  var index,		     
		          j;
          $("input[type=checkbox][name='taskInfo.status']").each(function(i) {  
        	  for( index=0;index<strStatus.length;index++){       
        	    if($(this).val()==strStatus[index]){
        	    	$(this).prop('checked',true);

        	    }
        	  }  
          })
		},
		
		 //默认选中第一行
		 chooseFisTr : function () {	
	 			var firstTr,
			        firstTrId;       
		        firstTr=$('.table-task-lists').find("tr").get(1);
		        firstTrId=$(firstTr).attr("id");
		        //alert(firstTrId);
		        $('#'+firstTrId).trigger('click');
		 },
	
		submitTaskInfo : function() {
			/**
			 * 提交任务
			 */
			var taskid = "";
			var  problemDescription = $("#js_taskInfo_problemDescription").val();

			$('.table-task-lists').find('.js-checkbox').each(function(i, ele) {

				if (ele.checked) {

					taskid = $(ele).attr('id');

					return false;
				}
			});
			if (!taskid.length) {
				alert("请先选择任务!");
				
				return false;
			}
			$('#js-update-task-form').ajaxSubmit({
				type : "POST",
				url : "submitTask!submitTask.action",
				data : "taskInfo.taskId=" + taskid,
				async : true,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				},
				beforeSubmit : function() {
					if(problemDescription.length>300) {
	 		     	       alert("问题描述不能超过300字!");
	 		     	       return false;
	 		        }else if(problemDescription.length==0) {
 		     	       alert("问题描述不能为空!");
		     	       return false;
		     	   }else{
		     		  return true;  
	 		     	       }	 					
				},
				success : function(data) {
					if (data == "1") {					
						var taskid=$('#js_taskInfo_taskId').text();
		  		    	var $tds=$('#'+taskid).find('td');		  		    
		  		    	var handleUser=$('#js_taskInfo_handleUser').text();
		  		    	if(handleUser==""){
		  		    		var processState="待处理";
		  		    	}else{
		  		    		var processState="运营打回";
		  		    	}		  		    
		  		    	$($tds[5]).text(processState);		  			  																
						$('#'+taskid).trigger('click');
						alert("提交成功!");						
					} else {
						alert("提交失败,只能新建或已处理状态下提交!");
					}
				}
			});
		},
		
		
		//关闭任务
		closeTaskInfo : function() {
			/**
			 * 关闭任务
			 */
			var taskid = "";
			$('.table-task-lists').find('.js-checkbox').each(function(i, ele) {
				if (ele.checked) {
					taskid = $(ele).attr('id');
					return false;
				}
			});
			if (!taskid.length) {
				alert("请先选择任务!");
				return false;
			}
			$.ajax({
				type : "POST",
				url : "closeTask!closeTask.action",
				data : "taskInfo.taskId=" + taskid,
				// formid
				async : true,
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
				},
				success : function(data) {
					if (data == "1") {						
						var taskid=$('#js_taskInfo_taskId').text();
		  		    	var $tds=$('#'+taskid).find('td');		  		    
		  		    	var processState="关闭";	
		  		    	 $('.shanchu').hide();
		  		    	$($tds[5]).text(processState);		  			  				
		  		    	$('#'+taskid).trigger('click');
		  		    	alert("关闭成功!");																	
					} else {
						alert("关闭失败,只能已处理状态下关闭!");
					}
				}
			});
		},
			
		 //清除上传图片的路径
		  clearAddress :function (obj){			  
			  var $file = $(obj).prev();
			  $file.after($file.clone().val("")); 
			  $file.remove();			  
//		    var clear=$(obj);
//		    var aa='';
//			 alert($('.js-imageName-clear'));			 
//		    var imageUrl = $(clear).prev();
//			alert(imageUrl.value);					
//			 $(imageUrl).attr('value','');	
//			 imageUrl.value='';
//			alert($(imageUrl).val()+"----"+imageUrl.value);
				
		 },
		 
		//修改并提交任务
		updateSubmitTaskInfo : function() {
			var  problemDescription = $("#js_taskInfo_problemDescription").val();
			$('#js-update-task-form').ajaxSubmit({
				target : "#output",
				beforeSubmit : function() {
					if(problemDescription.length>300) {
	 		     	       alert("问题描述不能超过300字!");
	 		     	       return false;
	 		        }else if(problemDescription.length==0) {
 		     	       alert("问题描述不能为空!");
		     	       return false;
		     	   }else{
	 	 		     	    	return ischeckupdate();
	 		     	       }	 					
				},
				success : function(responseText, statusText) {							  			
					if (responseText.result) {
		  				var taskid=$('#js_taskInfo_taskId').text();
		  		    	var $tds=$('#'+taskid).find('td');
		  		    	var problemType=$('#js-update-problemType').val();
		  		    	var priority=$('#js_taskInfo_priority').val();
		  		    	var systemName=$('#systemName').val();
		  		    	var handleUser=$('#js_taskInfo_handleUser').text();
		  		    	if(handleUser==""){
		  		    		var processState="待处理";
		  		    	}else{
		  		    		var processState="运营打回";
		  		    	}
		  		    	$($tds[5]).text(processState);
		  		    	$($tds[3]).text(problemType);
		  		    	$($tds[1]).text(systemName);
		  		    	$($tds[2]).text(priority);
		  				
		  		    	$('#'+taskid).trigger('click');
		  			} 
		  		  alert("修改并提交成功");
		  		  return true;
		  		},
				error : function() {
					alert("修改并提交失败");
				},
				url : 'updateSubmitTask!updateSubmitTask.action',
				type : 'post',
				dataType : 'json',
				clearForm : false,
				resetForm : false
				//timeout : 5000
			});
		},
		
	//分页
		goPage: function (currPage){ 
			var $forms = $('#js-search-criteria'); 
			$forms.append("<input type='hidden' name='currPage' value='"+currPage+" '>"); 
			$forms[0].submit(); 
			},		
			// 打回任务			
			backTaskInfo : function() {				
				$('#js-update-task-form').ajaxSubmit({
					target : "#output",
					beforeSubmit : function() {
					},
					success : function(data) {
			  			if (data=="1") {	
			  				var taskid=$('#js_taskInfo_taskId').text();
			  		    	var $tds=$('#'+taskid).find('td');			  		    	
			  		    	var processState="运营打回";
			  		    	$($tds[5]).text(processState);			  				  				
			  		    	$('#'+taskid).trigger('click');
			  						  			
			  			} 
			  			alert("打回成功");	
			  			return true;
			  		},
					error : function() {
						alert("打回失败")
					},
					url : 'backTask!backTask.action',
					type : 'post',
					dataType : 'json',
					clearForm : false,
					resetForm : false
					//timeout : 5000
				});
			},
				
		// 修改的保存任务			     
		updateTaskInfo : function() {		 	
			var  problemDescription = $("#js_taskInfo_problemDescription").val();
			$('#js-update-task-form').ajaxSubmit({
				target : "#output",
				beforeSubmit : function() {					
					if(problemDescription.length>300) {
 		     	       alert("问题描述不能超过300字!");
 		     	       return false;		     	       
 		     	     }else if(problemDescription.length==0) {
  		     	       alert("问题描述不能为空!");
		     	       return false;
		     	   }else{
 		     	    	return ischeckupdate();
 		     	     }	 
				},
				success : function(responseText, statusText) {		  			
		  			if (responseText.result) {	  					  	
		  				var taskid=$('#js_taskInfo_taskId').text();
		  		    	var $tds=$('#'+taskid).find('td');
		  		    	var problemType=$('#js-update-problemType').val();
		  		    	var priority=$('#js_taskInfo_priority').val();
		  		    	var systemName=$('#systemName').val();
		  		    	$($tds[3]).text(problemType);
		  		    	$($tds[1]).text(systemName);
		  		    	$($tds[2]).text(priority);
		  		    	
		  		    	$('#'+taskid).trigger('click');
		  		    	
		  			} 
		  			alert("修改成功");
		  			
		  		},
				error : function() {
					alert("修改失败")
				},
				url : 'updateTask!updateTask.action',
				type : 'post',
				dataType : 'json',
				clearForm : false,
				resetForm : false
			});
		},	
		deleteTaskInfo : function() {
			/**
			 * 删除任务
			 */
			var taskid = "";
			$('.table-task-lists').find('.js-checkbox').each(function() {
			
				if ($(this).prop('checked')) {
					taskid = $(this).attr('id');
					
					return false;

				}
			});
			if ("" == taskid) {
				alert("请先选择任务!");
				return false;
			}

			var r = window.confirm("确定要删除这条数据吗？");
			if (!r) {
				return;
			}
			$.ajax({
				type : "POST",
				url : "deleteTask!deleteTask.action",
				data : "taskInfo.taskId=" + taskid,
				async : true,
				error : function(request) {
					alert("Connection error");
				},
				success : function(data) {
				
					if (data == "1") {
						alert("删除成功!");
						window.location.href = 'selectTaskInfo!selectTaskInfo.action?taskInfo.status=1&taskInfo.status=2&taskInfo.status=3';
						
					} else {
						alert("删除失败!");
						$("#delete").attr("disabled", false);

					}
				}
			});
		},			
		//新增任务
		addDialog: function (){        	        	
            if(!$().dialog){
                 throw new Error('addDialog 方法: 依赖 jquery-ui.js'); 
            }
            var $dialog = $('#js-add-dialog'),
                $btn    = $('#js-add-btn'),
                $form   = $('#js-new-task-form');           
            $dialog.dialog({
                autoOpen: false,
                height: 400,
                width: 720,
                maxWidth: 720,
                modal: true,
                title: '新增',        
                buttons: {
                    '保存': function(event, ui) {  
                    	 var problemType = $("#js-add-problemType").val(),
                             priority = $("#js-add-priority").val(),
                             settlement = $("#systemName2").val();  
                    	 var  problemDescription = $("#js-add-problemDescription").val();    
                    	  $form.ajaxSubmit({
            		  		target : "#output",
            		  		beforeSubmit : function() {            		  			            		  		            		             		  		            		  			
            		  			// 表单提交前调用的function
            		  			if ($.trim(settlement) === '' ) {
            		     	       alert("请填写客户系统!");
            		     	       return false;
            		     	   } else if($.trim(problemType) === '') {
            		     	       alert("请填写问题类型!");
            		     	       return false;
            		     	   } else if($.trim(priority) === '') {
            		     	       alert("请填写优先级别!");
            		     	       return false;
            		     	   }/*else if(title.length==0) {
            		     	       alert("请填写任务标题!");
            		     	       return false;
            		     	   }else if(title.length>30) {
            		     	       alert("任务标题不能超过30字!");
            		     	       return false;
            		     	   }*/ else if(problemDescription.length==0) {
            		     	       alert("问题描述不能为空!");
            		     	       return false;
            		     	   }else if(problemDescription.length>300) {
            		     	       alert("问题描述不能超过300字!");
            		     	       return false;
            		     	   }else {
            		     		  return ischeckadd();
            		     	   }           		  			                   		     	   
            		  		},
            		  		success : function(responseText, statusText) {           		  			
            		  			if (responseText.result) {	  					  	
            		  				// 成功后调用查询方法
            		  				location.href = "selectTaskInfo!selectTaskInfo.action?taskInfo.status=1&taskInfo.status=2&taskInfo.status=3";
            		  				
            		  			}             		  			
            		  		},
            		  		error : function() {
            		  			alert('新增失败,请重新添加');
            		  			return false;
            		  		},
            		  		url : 'newTask!newTask.action',
            		  		type : 'post',
            		  		dataType : 'json',
            		  		/*async : 'true',*/
            		  		clearForm : false,
            		  		resetForm : false,
            		  		timeout : 10000
            		  	});                   	
                    },
                    '保存并提交': function(event, ui) {
                    	var  imgLen , i;
                   	    var  imgName, imgsName ;
                   	    var  $inputImgs= $(".js-input-imgs");  
                   	    imgLen=$inputImgs.length;
                   	 
                    	var problemType = $("#js-add-problemType").val(),
                             priority = $("#js-add-priority").val(),
                             settlement = $("#systemName2").val(); 
                    	    /* title= $("#js-add-taskTitle").val();*/
                    	 var  problemDescription = $("#js-add-problemDescription").val(); 
                    	 	  
                    	$form.ajaxSubmit({
           		  			target : "#output",
           		  			beforeSubmit : function() {
           		  			
           		  		// 表单提交前调用的function
            		  			if ($.trim(settlement) === '' ) {
            		     	       alert("请填写客户系统!");
            		     	       return false;
            		     	   } else if($.trim(problemType) === '') {
            		     	       alert("请填写问题类型!");
            		     	       return false;
            		     	   } else if($.trim(priority) === '') {
            		     	       alert("请填写优先级别!");
            		     	       return false;
            		     	   }/*else if(title.length==0) {
            		     	       alert("请填写任务标题!");
            		     	       return false;
            		     	   }else if(title.length>30) {
            		     	       alert("任务标题不能超过30字!");
            		     	       return false;
            		     	   }*/else if(problemDescription.length==0) {
            		     	       alert("问题描述不能为空!");
            		     	       return false;
            		     	   } else if(problemDescription.length>300) {
            		     	       alert("问题描述不能超过300字!");
            		     	       return false;
            		     	   }else {
            		     		  return ischeckadd();
              		     	   }
            		  	
           		     	   
           		  		},
           		  		success : function(responseText, statusText) {          		  			
           		  			if (responseText.result) {	  					  	           		  				
           		  			     alert("提交成功!");
           		  				// 成功后调用查询方法
           		  				location.href = "selectTaskInfo!selectTaskInfo.action?taskInfo.status=1&taskInfo.status=2&taskInfo.status=3";
           		  		
           		  			} 
           		  		   
           		  		},
           		  		error : function() {
           		  			alert('提交失败,请重新添加');
           		  			return false;
           		  		},
           		  		url : 'addSubmitTask!addSubmitTask.action',
           		  		type : 'post',
           		  		dataType : 'json',
           		  		/*async : 'true',*/
           		  		clearForm : false,
           		  		resetForm : false,
           		  		timeout : 10000
           		    	});       
                    },
                    '重置': function() {
                    	$form[0].reset();
                    	$('#js-new-task-form input[name="taskInfo.files"]').val('');
                    	$('.detach').detach();
                    	$('.tianjia').attr('disabled', false);
                    }
                }
            });

            $btn.on('click', function(){
            	$form[0].reset();
            	$('#js-new-task-form input[name="taskInfo.files"]').val('');
            	$('.detach').detach();           	
                $dialog.dialog('open');
                $('.tianjia').attr('disabled', false);
                
            });
        }
	};
})(window, jQuery, document);


