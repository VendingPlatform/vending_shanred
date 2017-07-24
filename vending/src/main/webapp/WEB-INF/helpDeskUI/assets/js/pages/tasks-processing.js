/*
* @Author     : lilonglong
* @Date       : 2015/08/06
* @Version    : 0.1.0
* @Description: 运维平台
* @Dependence : jQuery
* @Mail       : long_mailbox@sina.com
* @Reference  : http://codeguide.bootcss.com/
************************************************
************************************************
*/
var TaskProcessing = (function (window, $, document, undefined) {
   'use strict';
   var $forms = $("#js-search-criteria");
   
   var sign=$('#js_sign').val();

   if(sign==1){
	    $('.form-table').addClass("in");
   }else{
	    $('.form-table').removeClass("in");  
   } 
   
   $("#findTa").on('click', function() {
	   if($('.form-table').hasClass("in")){
			  $('#js_sign').val('1');

		   }else{
			  $('#js_sign').val('0'); 

		   } 
	     $forms[0].submit();

	});
	$("#deleteTa").on('click', function() {
		$forms[0].reset();
 	$("#js-search-criteria input[type=text]").val('');
		$("#js-search-criteria select").val('');

	});
   
   
	 //加载理赔系统
	   	   $.ajax({
	             type: "post",
	             url: "getSystem!getSystem.action",
	             data: "",
	             async: false,
	             dataType: "json",
	             error: function() {
	                 alert("加载理赔系统失败！");
	             },
	             success: function(datas) {
	               
	                 var options = "<option value='' selected='selected'>请选择</option>";
	                 for (var i = 0; i < datas.length; i++) {
	                     options += "<option value='" + datas[i].systemName+ "'>" + datas[i].systemName + "</option>";
	                 }
	        
	                
	                 $("#systemName1").html(options);//高级查询加载
	      
	             }
	         });
	         //加载问题类型
	           $.ajax({
	             type: "post",
	             url: "getProblemType!getProblemType.action",
	             data: "",
	             async: false,
	             dataType: "json",
	             error: function() {
	                 alert("加载问题类型失败！");
	             },
	             success: function(datas) {
	               
	                 var options = "<option value='' selected='selected'>请选择</option>";
	                 for (var i = 0; i < datas.length; i++) {
	                     options += "<option value='" + datas[i].problemTypeName+ "'>" + datas[i].problemTypeName + "</option>";
	                 }   
	                 
	                
	                 $("#js-select-problemType").html(options);//高级查询加载问题类型
	             }
	         });
    
	   

		


	    
	   		
	           
	           
	       	var initImg = function(ajaxData) {
	       		
	    		// 显示图片 
	    		var imgCount = ajaxData.filesSum, str = '', i, $imgGallery = $('#js-img-gallery');
	    	
	    		for (i = 0; i <imgCount; i++) {
	    			var v = ajaxData.taskId + "-" + i;
                     
	    			str += '<div class="col-md-3">'
	    					+"<a href=processingshowImage!processingshowImage.action?taskId="+ajaxData.taskId+"&index="+i+" class='fancybox fancybox.ajax'>"
	    					+ "<img alt='' class='img-thumbnail'"
	    					+ " src='showImage!showImage.action?index=" + i + "&taskId="
	    					+ ajaxData.taskId + "'/>"+"</a>" + "&nbsp;" + '</div>';
	    			
	    		}
	    		$imgGallery.html(str);
   
	       	}
   

	       	
	       	
	     var addFileInput = function () {
	          $('#js-add-file').on('click', '.btn.btn-default', function (event){
	            var $this = $(this);
	           /* var html = '<input type="file" class="margin-bottom-lg detach"  name="taskInfo.files">';*/
	            var html = '<div class="form-inline detach">'+
				 '<input type="file" class="margin-bottom-lg js-input-imgs form-control"  name="taskInfo.files">'+
				 '<button type="button" class="btn btn-danger margin-bottom-lg form-control js-imageName-clear" onclick="TaskProcessing.clearAddress(this)">'+	
				 '<i class="fa fa-close"></i>'+
				 '</button>	'+
				 '</div>' ;   
	            
	            if( $this.parent().children().children('input').size() == 4 ) {
	                $this.attr('disabled', true);
	            } else {
	                 $this.prev().after(html);
	                 
	                }
	        });
  };
  var ischeckupdate = function (){
		var  imgLen , i;
	    var  imgName, imgsName ;
	    var  $inputImgs= $(".js-input-imgs");  
	    imgLen=$inputImgs.length;
	   for(i=0;i<imgLen;i++){
				imgName=$($inputImgs[i]).val();
				if(imgName!=''){			
					imgsName=imgName.substr(imgName.length-4);           		  				
					if(imgsName==".png" || imgsName==".jpg"||imgsName==".JPG"||imgsName==".PNG"){ 	  					
					}else{
						alert("请上传png或者jpg格式的图片");
					return false;
					}	
				}	
     }
	   return true;
	   
 };        
   
   
   
   var viewTrInfo = function (){
	 
	   var $table = App.$content.find('.table-task-lists');
	   $table.on('click', 'tbody tr', function(){
		   $('#particulars input[name="taskInfo.files"]').val('');
		   $('.detach').detach();
		  
		   $("#js-add-file-btn").attr('disabled',false);
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
			$('#particulars')[0].reset();	
		
		  
		  
		  $.ajax({
			cache:true,// 缓存不会将界面清空
			type: "POST",
			url: "getss!getss.action?taskInfo.taskId="+taskId.text(),
			dataType: "json",
			error: function(requests){
				alert("信息读取失败");
			},
			success:function(data){
		
				initImg(data);
				
				var html="";
				var htmls="";
				var ht="";
			    for(var i=0;i<data.processRecord.length;i++){
			        html=html+"<tr><td>"+data.processRecord[i].handleUser+"</td><td>"+data.processRecord[i].handleTime+"</td>  <td>"+data.processRecord[i].remarks+"</td> </tr>";
			     }
			       //问题描述（历史）
				for ( var i = data.processRecord.length-1; i >=0; i--) {
					if(data.processRecord[i].problemDescription!=null){
						htmls+="<textarea class='margin-bottom form-control'  readonly='true'>"
						        +data.processRecord[i].problemDescription
						        +"</textarea>";
					}
				}
				//处理意见
				for ( var i = data.processRecord.length-1; i >=0; i--) {
					if(data.processRecord[i].hangleSuggestion!=null){
						ht+="<textarea class='margin-bottom form-control'  readonly='true'>"
						        +data.processRecord[i].hangleSuggestion
						        +"</textarea>";
					}
				}
				ht+="<textarea name='taskInfo.hangleSuggestion' id='js_taskInfo_hangleSuggestion' rows='5' class='margin-bottom form-control' ></textarea>"
			    $('#js-taskInfo-processRecord').html(html);
				$("#js-problemDescription").html(htmls);
				$("#js-hangleSuggestion").html(ht);
				$("#js_taskInfo_taskId").html(data.taskId);
				$("#js_taskInfo_settlement").html(data.settlement);
				$("#js_taskInfo_priority").html(data.priority);	
				$("#js_taskInfo_submissionTime").html(data.submissionTime);
				$("#js_taskInfo_problemType").html(data.problemType);
				$("#js_taskInfo_submitter").html(data.submitter);
				

				if(data.handleUser!=null){
					$("#js_taskInfo_handleUser").html(data.handleUser);
				}else{
					$("#js_taskInfo_handleUser").html("");
				}
				if(data.processTime!=null){
					$("#js_taskInfo_processTime").html(data.processTime);
				}else{
					$("#js_taskInfo_processTime").html("");
				}
			
			    $("#js_id").val(data.taskId);
			    $("#js_taskInfo_processState").val(data.processState);
			    $("#taskInfo_processState").html(data.taskInfo_processState);
			
			    if(data.processState==7){
			    $("#js-processing-btn").attr('disabled',false);
			    }else{
			    $("#js-processing-btn").attr('disabled',true);
			    }
			     
			    if(data.processState==5||data.processState==6){
			    	$("#taskProcessing-submit").attr('disabled',false);
			    }else{
			    	$("#taskProcessing-submit").attr('disabled',true);
			    } 
			}
	
	   		});
		  
	
	   });

   }; 
   
   var submitForm= function (){

   };
			
   var infoScorll = function (){
        App.$content.find('.task-info-scorll').slimScroll({
          allowPageScroll: false,
          size: '6px',
          railVisible:true,
          // 滚动条距离位置
          distance:'5px',
          railColor:'#000',
          // 滚动条滚动到顶部或底部时是否允许页面滚动,默认false
          alwaysVisible: true,
          // 滚动条背景轨迹透明度,默认0.2
          // railOpacity: 0.2,
          height: '462'
        });
   };
   
   

	
   var datepickerModule = function (){
       if( !$().datepicker) { 
           throw new Error('datepickerModule 方法: 依赖 jquery-ui.js'); 
      }

      var $from = $('#js-submit-satr-date'),
          $end  = $('#js-submit-end-date');
      
      $from.datepicker({
    	  changeMonth : true,
          changeYear : true,
         
          numberOfMonths : 1,
          showOn:  'button',
          buttonImageOnly: true,
          buttonText: '选择开始时间',
          onClose : function(selectedDate) {
        	  $end.datepicker("option", "minDate", selectedDate);
          }
      });
      $end.datepicker({
    	  changeMonth : true,
          changeYear : true,
          numberOfMonths : 1,
           showOn:  'button',
          buttonImageOnly: true,
          buttonText: '选择结束时间',
          onClose : function(selectedDate) {
        	  $from.datepicker("option", "maxDate", selectedDate);
          }
        });
  };
    return {
       
    	
    	
 	   checkAll :function(){
		   $("#checkAll").click(function() {
			    $("input[name='taskInfo.status']").prop("checked", this.checked);
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
	   
    	//状态回显
    	  backStatus : function(){
    		  var strStatus = $("#console-select-statusBack").val().split(',');		  
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
    	
    	
    	
    	// 提交任务			     
    	updateSubmit : function() {
    		if(null==$('#js_taskInfo_processState').val()||""==$('#js_taskInfo_processState').val()){
    			alert("请选择处理操作");
    			return;
    		}
    		$('#js-processState_hiddenInput').val($('#js_taskInfo_processState').val());
			$('#particulars').ajaxSubmit({
				target : "",
				beforeSubmit : function() {
					
					if(!ischeckupdate()){
						return false;
					}
				},
			
				success : function(data) {
					if(data==1){
                		alert('提交成功!');
                	  	window.location.href='dispose!dispose.action?taskInfo.status=5&taskInfo.status=6&taskInfo.status=7'; 
					}else if(data==9){
						alert('图片上传失败!');
						return false;
					}else if(data==7){
						alert('请先接收任务!谢谢!')
						return false;
					}else{
						alert('提交失败!');
						return false;
					}
		  		},
			
				url : 'particulars!particulars.action',
				type : 'post',
			
				dataType : 'json',
				clearForm : false,
				resetForm : false
				
			});
		},
    	
        init: function (){
            addFileInput();
            infoScorll();
            datepickerModule();
            viewTrInfo();
           
            
        },
       TeceiveTaskInfo : function() {
			
			/*  接收任务*/
			
			var taskid = "";
			$('.table-task-lists').find('.js-checkbox').each(function() {
			
				if ($(this).prop('checked')) {
					taskid = $(this).attr('id');
					
					return false;

				}
			});
			if ("" == taskid) {
				alert("请先选中要接收的任务。。。");
			}else{
			$.ajax({
				type : "POST",
				url : "TeceiveTask!TeceiveTask.action",
				data : "taskInfo.taskId=" + taskid,
				async : true,
				error : function(request) {
				
				},
				success : function(data) {
				     
					if (data == "1") {
						
						alert("任务接收成功!");
						
						window.location.href = 'dispose!dispose.action?taskInfo.status=5&taskInfo.status=6&taskInfo.status=7';
					
					}else if(data==10){
						alert("此任务已被他人接收");
						window.location.href = 'dispose!dispose.action?taskInfo.status=5&taskInfo.status=6&taskInfo.status=7';
					}else {
						alert("任务接收失败!");
						window.location.href = 'dispose!dispose.action?taskInfo.status=5&taskInfo.status=6&taskInfo.status=7';


					}
				}
			});
			}
		},
        //分页
    	goPage: function (currPage){ 
    		var $forms = $('#js-search-criteria'); 
    		$forms.append("<input type='hidden' name='currPage' value='"+currPage+" '>"); 
    		$forms[0].submit(); 
    		},

      	
   };
   
})(window, jQuery, document);